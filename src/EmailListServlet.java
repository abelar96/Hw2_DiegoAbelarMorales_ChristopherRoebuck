import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmailListServlet")
public class EmailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url ="/index.html";

        String action = request.getParameter("action");


        if (action.equals("add")){

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

          //  email = SimpleEncypt.EncryptString(email); // Encryption
            User user = new User(firstName,lastName,email);
            UserDB.insert(user); // static method, do not need to initialize object //
            // add mysql:mysql-connector-java:5.1.47 to maeven library
            //

        }
        else if (action.equals("viewAll")){
            //String firstName = request.getParameter("firstName");
            //String lastName = request.getParameter("lastName");
            //String email = request.getParameter("email");
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);
            url= "/viewAll.jsp";
        }
        else if (action.equals("delete")){

            String email = request.getParameter("email");
            UserDB.delete(email);
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
