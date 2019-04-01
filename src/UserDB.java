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
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
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
                "email_user_lastname = ?," +
                "email_user_email =? "+
                "WHERE  idemail_user = ?";
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(insert);
                ps.setString(1,user.getFirstname());
                ps.setString(2,user.getLastname());
                ps.setString(3,user.getEmail());
                ps.setInt(4,user.getId());

                return ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return 0;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }

        }
}

    public static int delete(int id) {

        Connection conc;
        PreparedStatement ps = null;
        String delete = "delete from email_user WHERE idemail_user = ?";

        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(delete);
                ps.setInt(1,id);

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

                UsersList(rs, users);

                return users;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static User selectUser(int id){
        Connection conc;
        PreparedStatement ps = null;
        String selectUser = "select * from email_user where idemail_user =?";
        ResultSet rs = null;
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(selectUser);
                ps.setInt(1,id);
                rs = ps.executeQuery();


                User user = new User();

                if (rs.next()){
                    user.setFirstname(rs.getString("email_user_firstname"));
                    user.setLastname(rs.getString("email_user_lastname"));
                    user.setEmail(rs.getString("email_user_email"));
                    user.setId(rs.getInt("idemail_user"));
                }

                return user;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static ArrayList <User> selectUsersByFname(String firstname){
        Connection conc;
        PreparedStatement ps = null;
        String selectUser = "select * from email_user where email_user_firstname=?";
        ResultSet rs = null;
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(selectUser);
                ps.setString(1,firstname);
                rs = ps.executeQuery();


                ArrayList<User> users = new ArrayList();

                UsersList(rs, users);

                return users;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static ArrayList <User> selectUsersByLname(String lastname){
        Connection conc;
        PreparedStatement ps = null;
        String selectUser = "select * from email_user where email_user_lastname=?";
        ResultSet rs = null;
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(selectUser);
                ps.setString(1,lastname);
                rs = ps.executeQuery();


                ArrayList<User> users = new ArrayList();

                UsersList(rs, users);

                return users;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static ArrayList <User> selectUsersByEmail(String email){
        Connection conc;
        PreparedStatement ps = null;
        String selectUser = "select * from email_user where email_user_email=?";
        ResultSet rs = null;
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_list", "root", "mysql");
                ps = conc.prepareStatement(selectUser);
                ps.setString(1,email);
                rs = ps.executeQuery();


                ArrayList<User> users = new ArrayList();

                UsersList(rs, users);

                return users;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    private static void UsersList(ResultSet rs, ArrayList<User> users) throws SQLException {
        while (rs.next()){
            User user = new User();
            user.setFirstname(rs.getString("email_user_firstname"));
            user.setLastname(rs.getString("email_user_lastname"));
            user.setEmail(rs.getString("email_user_email"));
            user.setId(rs.getInt("idemail_user"));

            users.add(user);
        }
    }


}
