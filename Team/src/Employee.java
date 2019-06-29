
import java.sql.*;
public class Employee
{
    String name;
    String designation;
    String phone_no;
    String email;
    Connection conn;
    ResultSet rs;
    Statement stmt;
    Employee()
    {
        try
        {     
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting","root","system");
        stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=stmt.executeQuery("select * from manage_employee");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
