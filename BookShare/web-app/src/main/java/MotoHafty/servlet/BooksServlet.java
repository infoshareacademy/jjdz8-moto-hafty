package MotoHafty.servlet;

import MotoHafty.domain.Book;
import MotoHafty.freemarker.TemplateProvider;
import MotoHafty.repository.BookRepository;
import MotoHafty.service.Utils;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //TODO dodaj pattern dla pola imgurl w add-book.ftlh na adres kończący się .jpg/.jpeg/.png/.gif

        req.setCharacterEncoding("UTF-8");

        Book newBook = new Book();

        newBook.setTitle(Optional.ofNullable(req.getParameter("title")).orElse("").toString());
        newBook.setAuthors(Optional.ofNullable(Arrays.asList(req.getParameterValues("author"))).orElse(new ArrayList<>()));
        newBook.setMainAuthorName(Optional.ofNullable(req.getParameterValues("author")[0]).orElse("").toString());
        newBook.setCategory(Optional.ofNullable(req.getParameter("category")).orElse("").toString());
        newBook.setIsbn(Optional.ofNullable(req.getParameter("isbn")).orElse("").toString());
        newBook.setImgUrl(Optional.ofNullable(req.getParameter("imgUrl")).orElse("").toString());
        newBook.setDescription(Optional.ofNullable(req.getParameter("description")).orElse("").toString());
        Boolean isRead = false;
        if (req.getParameter("read") != null && req.getParameter("read").equals("on")) { isRead = true; }
        newBook.setRead(isRead);
        newBook.setInputDate(Utils.generateDateInStringNow());

        bookRepository.addNewBooK(newBook);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription", "Wszystkie książki w BookShare");
        dataModel.put("pageTitle", "BookShare Lista książek");
        dataModel.put("jumbotronText", "W biblioteczce znajdują się wszystkie wprowadzone w system książki.");
        dataModel.put("jumbotronTitle", "Moja biblioteczka");
        dataModel.put("books", bookRepository.readBooks());

        Template template = templateProvider.getTemplate(getServletContext(), "books.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParameter = req.getParameter("id");
        bookRepository.deleteBook(Integer.valueOf(idParameter));
    }
}
