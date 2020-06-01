package MotoHafty.servlet;

import MotoHafty.freemarker.TemplateProvider;
import MotoHafty.repository.BookRepository;
import MotoHafty.storage.UserDb;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shelf")
public class ShelfServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Inject
    private UserDb userDb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona półki do wypożyczeń");
        dataModel.put("pageTitle","Półka do wypożyczeń");
        dataModel.put("shelfBooks", bookRepository.readShelfBooks(1));
        dataModel.put("user", userDb.getAllUsers().get(1));

        Template template = templateProvider.getTemplate(getServletContext(),"shelf.ftlh");

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
        bookRepository.removeBookFromShelf(Integer.valueOf(idParameter));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParameter = req.getParameter("id");
        bookRepository.clearShelf(Integer.valueOf(userIdParameter));
    }
}