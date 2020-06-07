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
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/edit-book")
public class BookEditServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private BookRepository bookRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String idToEdit = req.getParameter("id");
        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(),"edit-book.ftlh");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona edytowania ksiażki");
        dataModel.put("pageTitle","Edytowanie książki");
        dataModel.put("jumbotronText", "Popraw pola, aby edytować książkę.");
        dataModel.put("jumbotronTitle", "Edytuj książkę");
        dataModel.put("categoryList", Utils.getCategoryList());
        dataModel.put("bookId", idToEdit);
        dataModel.put("bookTitle", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getTitle());
        dataModel.put("bookAuthors", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getAuthors());
        dataModel.put("bookCategory", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getCategory());
        dataModel.put("bookISBN", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getIsbn());
        dataModel.put("bookImgURL", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getImgUrl());
        dataModel.put("bookDescription", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getDescription());
        dataModel.put("bookRead", bookRepository.readBooks().get(Integer.valueOf(idToEdit)).getRead());



        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        req.setCharacterEncoding("UTF-8");
        Integer bookId = Integer.valueOf(req.getParameter("id"));

        Book editedBook = bookRepository.readBooks().get(bookId);
        editedBook.setTitle(req.getParameter("editTitle"));
        editedBook.setAuthors(Arrays.asList(req.getParameterValues("author")));
        editedBook.setMainAuthorName(req.getParameterValues("author")[0]);
        editedBook.setCategory(req.getParameter("editCategory"));
        editedBook.setIsbn(req.getParameter("editIsbn"));
        editedBook.setDescription(req.getParameter("editDescription"));
        Boolean isRead = false;
        if (req.getParameter("editRead") != null && req.getParameter("editRead").equals("on")) { isRead = true; }
        editedBook.setRead(isRead);

        bookRepository.updateBook(Integer.valueOf(bookId), editedBook);

        resp.setContentType("text/html;charset=UTF-8");


        Template template = templateProvider.getTemplate(getServletContext(),"edit-book.ftlh");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("pageDescription","To jest strona edytowania ksiażki");
        dataModel.put("pageTitle","Edytowanie książki");
        dataModel.put("jumbotronText", "Popraw pola, aby edytować książkę.");
        dataModel.put("jumbotronTitle", "Edytuj książkę");
        dataModel.put("categoryList", Utils.getCategoryList());
        dataModel.put("bookId", bookId);
        dataModel.put("bookTitle", bookRepository.readBooks().get(Integer.valueOf(bookId)).getTitle());
        dataModel.put("bookAuthors", bookRepository.readBooks().get(Integer.valueOf(bookId)).getAuthors());
        dataModel.put("bookCategory", bookRepository.readBooks().get(Integer.valueOf(bookId)).getCategory());
        dataModel.put("bookISBN", bookRepository.readBooks().get(Integer.valueOf(bookId)).getIsbn());
        dataModel.put("bookImgURL", bookRepository.readBooks().get(Integer.valueOf(bookId)).getImgUrl());
        dataModel.put("bookDescription", bookRepository.readBooks().get(Integer.valueOf(bookId)).getDescription());
        dataModel.put("bookRead", bookRepository.readBooks().get(Integer.valueOf(bookId)).getRead());



        PrintWriter printWriter = resp.getWriter();
        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}