package MotoHafty.servlet;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/add-book")
public class BookAddServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(),"add-book.ftlh");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona dodawania nowej ksiażki");
        dataModel.put("pageTitle","Dodawanie nowej książki");
        dataModel.put("jumbotronText", "Wypełnij formularz aby dodać nową książkę");
        dataModel.put("jumbotronTitle", "Dodaj nową książkę");
        dataModel.put("bookId", bookRepository.readBooks().keySet().size()+1);
        dataModel.put("categoryList", Utils.getCategoryList());

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}