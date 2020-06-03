package quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QueDb {
	
	public static int save(String que,String A,String B,String C,String ans){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into ques(que,A,B,C,ans,) values(?,?,?,?,?)");
			ps.setString(1,que);
			ps.setString(2,A);
			ps.setString(3,B);
			ps.setString(4,C);
			ps.setString(5,ans);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(int queno){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from ques where queno=?");
			ps.setInt(1,queno);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}