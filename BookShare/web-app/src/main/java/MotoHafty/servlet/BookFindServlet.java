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
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/find-book")
public class BookFindServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(),"find-book.ftlh");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona wyszukiwania ksiażek");
        dataModel.put("pageTitle","Wyszukiwanie książki");
        dataModel.put("jumbotronText", "Wykorzystaj pola, aby wyszukać książki");
        dataModel.put("jumbotronTitle", "Wyszukaj książkę");
        dataModel.put("categoryList", Utils.getCategoryList());

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String anyToFind = req.getParameter("findAny").toLowerCase();
        String titleToFind = req.getParameter("findTitle").toLowerCase();
        String authorToFind = req.getParameter("findAuthor").toLowerCase();
        String categoryToFind = req.getParameter("findCategory").toLowerCase();
        String isbnToFind = req.getParameter("findIsbn").toLowerCase().replaceAll("[^0-9]","");
        String descriptionToFind = req.getParameter("findDescription").toLowerCase();

        Map<Integer,Book> foundBooks = bookRepository.findBook(anyToFind, titleToFind, authorToFind, categoryToFind, isbnToFind, descriptionToFind);

        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription", "Wyniki wyszukiwania");
        dataModel.put("pageTitle", "Wyniki wyszukiwania\"");
        dataModel.put("jumbotronText", "Poniżej znajdują się wyniki wyszukiwania");
        dataModel.put("jumbotronTitle", "Wyniki wyszukiwania");
        dataModel.put("books", foundBooks);

        Template template = templateProvider.getTemplate(getServletContext(), "books.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}