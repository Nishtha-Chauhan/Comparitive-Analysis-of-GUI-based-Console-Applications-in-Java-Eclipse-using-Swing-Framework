package quiz;
import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
	public static Connection getConnection(){
		Connection con=null;
		try{
			con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/quiz?"
                            + "user=root&password=Yashpal@18");
		
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
}