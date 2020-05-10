package MotoHafty.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html lang=\"pl-PL\">");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\">");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<meta charset=\"UTF-8\">");

        printWriter.println("Witaj w BookShare - brzydkim kaczątku programowania webowego xD");
        printWriter.println("Wybierz odpowiednią opcję:");
        printWriter.println("<button onclick=\"location.href = '/test';\" id=\"1\" class=\"float-left submit-button\" >Dodaj nową książkę</button> ");

        printWriter.println("</body>");
        printWriter.println("</html>");
    }

}
