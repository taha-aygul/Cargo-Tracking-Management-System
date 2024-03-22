import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

public class Database implements IDatabase{
	
	private String user_name="root";
	private String password="123456";
	private String db_name="dtb";
	private String host="localhost";
	private String port="3306";
	
	private static Database instance;
	
	private Database() {}
	
	public static Database getInstance() {
		if(instance==null) {
			instance =new Database();
		}
		return instance;
	}
	
	
	public int changeAID(String user_ID,String addid) {
		int a=0;
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Update people Set address_id= '%s' where ID = '%s'",addid ,user_ID);
	
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			 a=myStat.executeUpdate(query);
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public String getAddressID(String street,String town,String city,String apa,String door) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select address_id from address where street_name='%s' and town_name='%s' and city_name='%s' and apartment_name='%s' and door_no='%s'",street,town,city,apa,door);
		String address_id="";
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			rs.next();
			address_id=rs.getString("address_id");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return address_id;
	}
	

	public int addPeople(String name,String address_id,String surname,int type,String phone,String email,String pass)
	{
		boolean flag = checkEmail(email);
		if(flag) {
			return 2;
		}
		else {
			int a=0;
			String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
			String query="Insert Into people (name,address_id,surname,type,phone,email,password) VALUES(" + "'" + name +"',"+"'"+ address_id + "',"+"'"+surname + "',"+"'"+type +"',"+"'"+phone +"',"+"'"+email +"',"+"'"+pass +"')";
			try {
				Connection myConn=DriverManager.getConnection(url,user_name,password);
				Statement myStat=myConn.createStatement();
				a= myStat.executeUpdate(query);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return a;
		
		
		}
	}
	

	public int addAddress(String street,String town,String city,String apa,String door)
		{			
			int a=0;
			String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
			String query="Insert Into address (street_name,town_name,city_name,apartment_name,door_no) VALUES(" + "'" + street +"',"+"'"+town + "',"+"'"+city +"',"+"'"+apa +"',"+"'"+door +"')";
			try {
				;
				Connection myConn=DriverManager.getConnection(url,user_name,password);
				Statement myStat=myConn.createStatement();
				
				a= myStat.executeUpdate(query);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return a;
		
	}
	

	public String getAddress(String ID,String name,String surname) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select address_id from people where ID='%s' and name='%s' and surname='%s'",ID,name,surname);
		String address="";
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			rs.next();
			address=rs.getString("address_id");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return address;
	}
	
	
	public Address getAddress2(String address) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select street_name,town_name,city_name,apartment_name,door_no from address where address_id='%s'",address);
		Address a = null;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			ResultSet rs=myStat.executeQuery(query);
			rs.next();
			a=new Address(rs.getString("street_name"),rs.getString("town_name"),rs.getString("city_name"),
					rs.getString("apartment_name"),rs.getString("door_no"));

		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public int addCargo(String cuID,String delAddress,String sentAddress,String recname,
			String recsurname,String senderName,String date,String content)
	{
		
		int a=0;
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query="Insert Into cargo (cargo_user_id,delivery_address,sent_address,recipient_name,recipient_surname,sender_name,shipping_date,cargo_content) VALUES(" + "'" + cuID +"',"+"'"+delAddress + "',"+"'"+sentAddress +
				"',"+"'"+recname +"',"+"'"+recsurname +"',"+"'"+senderName +"',"+"'"+date+"',"+"'"+content +"')";

		try {
			;
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			 a=myStat.executeUpdate(query);
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	public int queryLen(String type) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query="Select * from people where type="+type;
		int rowCount = 0;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			ResultSet rs=myStat.executeQuery(query);
			
			while(rs.next()) {
				
				rowCount++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	

	public int queryLenCargo(String ID,String type) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query;
		if (type.equals("1")||type.equals("3")) {
			query="Select * from cargo ";
		}
		else {
			query=String.format("Select * from cargo where cargo_user_id='%s'",ID);
		}
		int rowCount = 0;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			ResultSet rs=myStat.executeQuery(query);
			
			while(rs.next()) {
				
				rowCount++;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	

	

	public Queue<People> listAllEmployee(String type) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query="Select * from people where type="+type;
		
		Queue<People> emps= new LinkedList<>();
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			ResultSet rs=myStat.executeQuery(query);
			
			while(rs.next()) {
				
				People emp=new People(rs.getString("ID"),rs.getString("name"),rs.getString("surname"),rs.getString("phone"));
				emps.add(emp);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	

	public String[][] listAllCargo(String ID,String type) {
		String query;
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		if (type.equals("1")||type.equals("3")) {
			query="Select * from cargo ";
		}
		else {
			query=String.format("Select * from cargo where cargo_user_id='%s'",ID);
		}
		
		int counter=0;
		String[][] a= new String[queryLenCargo(ID,type)][7];
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			ResultSet rs=myStat.executeQuery(query);
			
			while(rs.next()) {
				
				a[counter][0]=rs.getString("cargoID");
				a[counter][1]=rs.getString("delivery_address");
				a[counter][2]=rs.getString("sent_address");
				String rname=rs.getString("recipient_name");
				String rsurname=rs.getString("recipient_surname");
				String c=rname+" "+rsurname;
				a[counter][3]=c;
				a[counter][4]=rs.getString("sender_name");
				a[counter][5]=rs.getString("shipping_date");
				a[counter][6]=rs.getString("cargo_content");
				counter++;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public int cancelCargo(String n,String ID) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Delete from cargo where cargoID ='%s' and sender_name='%s' ",ID,n);
		int a = 0;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			 a=	myStat.executeUpdate(query);
			System.out.println(a);
			System.out.println(n);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public int changePass(String npass,String opass,String ID,String n,String s ) {
		int a=0;
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Update people Set password= '%s' where ID ='%s' and name='%s' and surname='%s' and password ='%s'",npass,ID,n,s,opass);
	
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			 a=myStat.executeUpdate(query);
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public String[] getNameAndSurname(String email, String pass) {
		String[] a=new String[4];
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select name,surname,type,ID from people where email='%s' and password='%s'",email,pass);
		
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			while(rs.next()) {
				
				a[0]=rs.getString("ID");
				a[1]=rs.getString("name");
				a[2]=rs.getString("surname");
				a[3]=rs.getString("type");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return a;
	}
	

	public String[] getCargo(String n, String s,String cargoID, String sender,String type) {
		String[] a=new String[7];
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query;
		if(type.equals("1")||type.equals("3")) {
			query=String.format("Select * from cargo where cargoID='%s' and recipient_name='%s' and recipient_surname='%s'",cargoID,n,s);
		}
		else {
			query=String.format("Select * from cargo where cargoID='%s' and recipient_name='%s' and recipient_surname='%s' and sender_name='%s'",cargoID,n,s,sender);
		}
		
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			while(rs.next()) {
				
				a[0]=rs.getString("cargoID");
				a[1]=rs.getString("delivery_address");
				a[2]=rs.getString("sent_address");
				String rname=rs.getString("recipient_name");
				String rsurname=rs.getString("recipient_surname");
				String c=rname+" "+rsurname;
				a[3]=c;
				a[4]=rs.getString("sender_name");
				a[5]=rs.getString("shipping_date");
				a[6]=rs.getString("cargo_content");
						
		}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	

	public int delete(String name,String surname,String ID,String type) {
		int a=0;
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Delete from people where  name='%s' and surname='%s' and ID='%s' and type=%s",name,surname,ID,type);
		try {
		
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			 a=myStat.executeUpdate(query);
			
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	public boolean check(String email,String pass) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select email,password from people where email='%s' and password='%s'",email,pass);
		boolean flag=false;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			while(rs.next()) {
				flag=true;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	public boolean checkEmail(String email) {
		String url="jdbc:mysql://" + host + ":" + port + "/" + db_name;
		String query=String.format("Select email from people where email='%s'",email);
		boolean flag=false;
		try {
			
			Connection myConn=DriverManager.getConnection(url,user_name,password);
			Statement myStat=myConn.createStatement();
			
			
			ResultSet rs=myStat.executeQuery(query);
			while(rs.next()) {
				flag=true;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
