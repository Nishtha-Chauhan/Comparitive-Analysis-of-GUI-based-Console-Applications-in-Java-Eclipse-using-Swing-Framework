package watersupply;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupplierDb {
	
	public static int save(String name,String password,String email,String address,String city,String contact,String tankers){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into sup(name,password,email,address,city,contact,tankers) values(?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
			ps.setString(7,tankers);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from sup where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int update(String tankers,int id){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE sup SET tankers=? WHERE id=?");
			ps.setString(1, tankers);
			ps.setInt(2, id);
			//System.out.println("tankers ="+tankers+"id="+id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from sup where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}