package watersupply;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FeedDb {
	
	public static int save(String sup_id,String name,String desc,String tanks_inc){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into feed(sup_id,name,desc,tanks_inc) values(?,?,?,?)");
			ps.setString(1,sup_id);
			ps.setString(2,name);
			ps.setString(3,desc);
			ps.setString(4,tanks_inc);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;

}
}