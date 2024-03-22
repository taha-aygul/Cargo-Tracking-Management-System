import java.text.SimpleDateFormat;
import java.util.Date;
public class Dat {
private static Dat instance;
	
	
	private Dat() {}
	
	public static Dat getInstance() {
		if(instance==null ) {
			instance =new Dat();
			
		}
		return instance;
	}
	
	public String getDate() {
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		String strDate = formatter.format(date);  
		  
		return strDate;
	}
	
}
