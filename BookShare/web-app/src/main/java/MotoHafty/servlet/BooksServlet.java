package MotoHafty.servlet;

import MotoHafty.domain.Book;
import MotoHafty.freemarker.TemplateProvider;
import MotoHafty.repository.BookRepository;
import MotoHafty.service.Utils;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
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
        book.setTitle(req.getParameter("title"));
        book.setMainAuthorName(req.getParameter("mainAuthorName"));
        book.setCategory(req.getParameter("category"));
        book.setIsbn(req.getParameter("isbn"));
        book.setDescription(req.getParameter("descritpion"));
        book.setRead(Boolean.valueOf(req.getParameter("isRead")));
        book.setImgUrl("");
        book.setInputDate(Utils.generateDateInStringNow());
        List<String> authors = new ArrayList<>();
        authors.add(book.getMainAuthorName());
        book.setAuthors(authors);
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
}
