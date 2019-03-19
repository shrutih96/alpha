package serve;
import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

	public static Connection getConnection() {
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/db_emp","root","admin");
			System.out.println("Connected");
			return con;
		
		
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
			
	}
	
	public static boolean validateUser(String userID, String password, Connection con) {
		boolean flag=false;
		
		try {
			
			String sq="select * from users where userID=? and password=?";
			PreparedStatement p;
			p = con.prepareStatement(sq);
			p.setString(1,userID);
			p.setString(2,password);
			ResultSet rs=p.executeQuery();
			
			while(rs.next()) {
				flag= true;
				break;
			}
			p.close();
			con.close();
			return flag;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static ArrayList<Data> displayAll(Connection con) {
		
try {
			
			String sq="select * from users";
			PreparedStatement p;
			p = con.prepareStatement(sq);
			ResultSet rs=p.executeQuery();
			
			
			
			ArrayList<Data> al=new ArrayList();
			
			while(rs.next()) {
				String str=rs.getString(1).toUpperCase();
				System.out.println("STR= "+str);
				
				Data d=new Data();
				
				d.setUserID(rs.getString(1) );
				d.setPassword(rs.getString(2));
				al.add(d);
				
			}	
		return al;
	}
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return null;
}
	
}
	
	public static ArrayList<Data> display(String userID, Connection con) {
		System.out.println(userID);
		
		try {
			
			String sq="select * from users where userID=?";
			PreparedStatement p;
			p = con.prepareStatement(sq);
			p.setString(1,userID.trim());
			ResultSet rs=p.executeQuery();
			
			
			ArrayList<Data> al=new ArrayList();
			while(rs.next()) {
				
				Data d=new Data();
				d.setUserID(rs.getString(1) );
				System.out.println(d.getUserID());
				d.setPassword(rs.getString(2));
				al.add(d);
				
				
			}
			return al;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
