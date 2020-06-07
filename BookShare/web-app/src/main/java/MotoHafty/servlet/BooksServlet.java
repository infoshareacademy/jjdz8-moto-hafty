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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Book book = new Book();

        if (req.getParameter("title")==null) book.setTitle(" ");
        else book.setTitle(req.getParameter("title"));

        if (req.getParameter("mainAuthorName")==null) book.setMainAuthorName(" ");
        else book.setMainAuthorName(req.getParameter("mainAuthorName"));

        book.setCategory(req.getParameter("category"));

        if (req.getParameter("isbn")==null) book.setIsbn(" ");
        else book.setIsbn(req.getParameter("isbn"));

        if (req.getParameter("description")==null) book.setDescription(" ");
        else book.setDescription(req.getParameter("description"));

        book.setRead(req.getParameter("isRead").equals("on"));

        if (req.getParameter("imgUrl") == null) book.setImgUrl(" ");
        else book.setImgUrl(req.getParameter("imgUrl"));

        book.setInputDate(Utils.generateDateInStringNow());

        List<String> authorList = new ArrayList<>();
        String anotherAuthor = req.getParameter("anotherAuthor");
        authorList.add(book.getMainAuthorName());
        authorList.add(anotherAuthor);
        book.setAuthors(authorList);
        bookRepository.addNewBooK(book);
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
