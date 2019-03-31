import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    public static void closePrepareStatement (Statement pst){

        try {
            if(pst != null)
                pst.close();
        }catch (SQLException e){
         e.printStackTrace();
        }

    }

}

