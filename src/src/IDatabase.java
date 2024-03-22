import java.util.Queue;

public interface IDatabase {
	int addPeople(String name,String address_id,String surname,int type,String phone,String email,String pass);
	
	int addCargo(String cuID,String delAddress,String sentAddress,String recname,
			String recsurname,String senderName,String date,String content);
	
	int queryLen(String type);
	
	int queryLenCargo(String ID,String type);
	
	Queue<People> listAllEmployee(String type);
	
	String[][] listAllCargo(String ID,String type);
	
	int cancelCargo(String n,String ID);
	
	int changePass(String npass,String opass,String ID,String n,String s );
	
	String[] getNameAndSurname(String email, String pass);
	
	String[] getCargo(String n, String s,String cargoID, String sender,String type);
	
	int delete(String name,String surname,String ID,String type);
	
	boolean check(String email,String pass);
}
