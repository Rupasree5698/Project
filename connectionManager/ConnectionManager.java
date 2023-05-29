package connectionManager;
import java.sql.*;

public class ConnectionManager 
{
   Connection con = null;
   public Connection establishConnection() throws ClassNotFoundException, SQLException{
	   Class.forName("com.mysql.cj.love.Driver");
	   con = DriverManager.getConnection("love:mysql://localhost:3306/InventoryManagement","root","root");
	   return con;
   }
   public void closeConnection() throws SQLException{
	   con.close();
   }
}