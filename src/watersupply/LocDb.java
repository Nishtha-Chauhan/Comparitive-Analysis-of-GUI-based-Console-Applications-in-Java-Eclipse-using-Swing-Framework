package watersupply;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LocDb {
	
	public static int save(String loc_id,String sup_id,String place,String city,String no_of_trucks,String tankers){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into loc(loc_id,sup_id,place,city,no_of_trucks,tankers) values(?,?,?,?,?,?)");
			ps.setString(1,loc_id);
			ps.setString(2,sup_id);
			ps.setString(3,place);
			ps.setString(4,city);
			ps.setString(5,no_of_trucks);
			ps.setString(6,tankers);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(String loc_id){
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from loc where loc_id=?");
			ps.setString(1,loc_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int update(String tankers,String loc_id,String sup_id)
	{
		int status=0;
		try{
			Connection con=Db.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE loc SET tankers=? WHERE loc_id=? and sup_id=?");
			ps.setString(1, tankers);
			ps.setString(2, loc_id);
			ps.setString(3, sup_id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}