package MotoHafty.servlet;

import MotoHafty.freemarker.TemplateProvider;
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

@WebServlet("/find-book")
public class FindBookServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona z wyszukiwarką książek");
        dataModel.put("pageTitle","Wyszukiwarka książek");
        dataModel.put("jumbotronText", "Już wkrótce będziesz mógł wyszukać konkretną książkę z biblioteczki");
        dataModel.put("jumbotronTitle", "Wyszukaj książkę");

        Template template = templateProvider.getTemplate(getServletContext(),"find-book.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}