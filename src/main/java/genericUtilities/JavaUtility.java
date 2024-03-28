package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This calss consists of Java specific generic methods
 * @author ganta
 *
 */
public class JavaUtility {
	/**
	 * This method will generatethe system date in required format
	 */
	public String getDate()
	{
		Date d= new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date=f.format(d);
		return date;
	}

}
