package MotoHafty.servlet;

import MotoHafty.freemarker.TemplateProvider;
import MotoHafty.repository.BookRepository;
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

@WebServlet("/book")
public class BookPreview extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String idParameter = req.getParameter("id");
        if (bookRepository.readBooks().get(Integer.valueOf(idParameter)).getImgUrl().isBlank()){
            bookRepository.readBooks().get(Integer.valueOf(idParameter)).setImgUrl("https://dictionary.cambridge.org/pl/images/thumb/book_noun_001_01679.jpg?version=5.0.97");
        }
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona podglądu pojedynczej książki");
        dataModel.put("pageTitle","BookShare podgląd pojedynczej książki");
        dataModel.put("book", bookRepository.readBooks().get(Integer.valueOf(idParameter)));

        Template template = templateProvider.getTemplate(getServletContext(),"book.ftlh");

        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
