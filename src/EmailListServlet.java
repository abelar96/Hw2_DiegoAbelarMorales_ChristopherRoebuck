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

        String url = null;

        String action = request.getParameter("action");


        if (action.equals("add")){

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(firstName,lastName,email);
            UserDB.insert(user);

            url ="/success.html";
            // static method, do not need to initialize object //
            // add mysql:mysql-connector-java:5.1.47 to maeven library

        }
        else if (action.equals("viewAll")){

            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);

            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/viewAll.jsp";
            }


        }
        else if (action.equals("delete")){

            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);

            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/delete.jsp";
            }
            ;

        }
        else if (action.equals("remove")){
            int email = Integer.parseInt(request.getParameter("id"));
            UserDB.delete(email);

            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);


            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/delete.jsp";
            }


        }
        else if (action.equals("update")){

            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);
            url= "/update.jsp";

        }
        else if (action.equals("updateR")){

          int id = Integer.parseInt(request.getParameter("id"));
           User user = UserDB.selectUser(id);
            request.setAttribute("user",user);

           url="/updateR.jsp";

        }
        else if (action.equals("updateRecord")){

            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(firstName,lastName,email,id);
            UserDB.update(user);

            url ="/success.html";

        }
        else if(action.equals("searchFname")){
            String fname = request.getParameter("firstName");
            ArrayList<User> users = UserDB.selectUsersByFname(fname);
            request.setAttribute("users",users);
            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/search.jsp";
            }


        }
        else if(action.equals("searchLname")){
            String lname = request.getParameter("lastName");
            ArrayList<User> users = UserDB.selectUsersByLname(lname);
            request.setAttribute("users",users);
            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/search.jsp";
            }


        }
        else if(action.equals("searchEmail")){
            String email = request.getParameter("email");
            ArrayList<User> users = UserDB.selectUsersByEmail(email);
            request.setAttribute("users",users);

            if (users.size() ==0){
                url ="/noUsersFound.html";
            }
            else {
                url= "/search.jsp";
            }


        }

        getServletContext().getRequestDispatcher(url).forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
