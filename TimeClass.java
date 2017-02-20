import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeClass {
	public static String timeStamp(){
	DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Date dateobj = new Date();
    return df.format(dateobj);
	}
}