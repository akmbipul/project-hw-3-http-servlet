package banking;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
  Please implement servlet life cycle so that user from the browser can enter account number and pin number.
  After receiving the request, please parse the the user data and send the response to the client.

  After implementing servlet,web.xml and index.jsp, deploy on Tomcat Server
 */
@WebServlet(name = "LogInToMyBank",urlPatterns = "login")
public class LogInToMyBank extends HttpServlet {
    public String massage;

    //implement initialize method
    public void inIt() throws ServletException{
        System.out.println("........Servlet Initializing.......");
        massage ="Welcome To Web World!....";
    }

    //implement doGet method
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>"+ "..You don't need to sign in to watch free demo.." + "<h1>");
        System.out.println("..........Servlet called doGet method..........");
    }

    //implement doPost method
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userName.equalsIgnoreCase("bipul")&&password.equalsIgnoreCase("akm1234")){
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<h1> You are authorized user. Welcome to Servlet Demo !");
            System.out.println("..........Servlet called doPost method..........");
        }else {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<h1>" + "You are not authorized user. So You are not Welcome to Servlet Demo !");
            System.out.println("..........Servlet called doPost method..........");
        }

    }

    public void destroy(){
        System.out.println("destroying servlet");
    }

}
