import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB implements Serializable {


    public static int insert(User user) {

        Connection conc;
        PreparedStatement ps = null;
        String insert = "insert into email_user(email_user_firstname, email_user_lastname, email_user_email) values(?,?,?)";

        {
            try {

               Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "mysql");
                ps = conc.prepareStatement(insert);
                ps.setString(1,user.getFirstname());
                ps.setString(2,user.getLastname());
                ps.setString(3,user.getEmail());

                return ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return 0;
            }finally {
              DBUtil.closePrepareStatement(ps);
            }
        }

    }


    public static int update(User user) {

        Connection conc;
        PreparedStatement ps = null;
        String insert = "update email_user set " +
                "email_user_firstname = ?, " +
                "email_user_lastname = ?" +
                "WHERE email_user_email ?";
        {
            try {

                Class.forName(".com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "mysql");
                ps = conc.prepareStatement(insert);
                ps.setString(1,user.getFirstname());
                ps.setString(2,user.getLastname());
                ps.setString(3,user.getEmail());

                return ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return 0;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }

        }
}

    public static int delete(String email) {

        Connection conc;
        PreparedStatement ps = null;
        String delete = "delete from email_user WHERE emai_user_email = ?";

        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "mysql");
                ps = conc.prepareStatement(delete);
                ps.setString(1,email);

                return ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return 0;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static ArrayList<User> selectUsers() {

        Connection conc;
        PreparedStatement ps = null;
        String selectAll = "select * from email_user";
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList();
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(selectAll);
                rs = ps.executeQuery();

                while (rs.next()){
                   User user = new User();
                   user.setFirstname(rs.getString("email_user_firstname"));
                    user.setLastname(rs.getString("email_user_lastname"));
                    user.setEmail(rs.getString("email_user_email"));
                    users.add(user);
                }

                return users;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }


}
