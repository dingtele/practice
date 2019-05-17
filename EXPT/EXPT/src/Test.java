import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String id;
	public java.util.Date date;

//	public static void main(String[] args) throws Exception
//	{
//		Test[] test = new Test[2];
//		test[0].setId("3");
//		test[0].setDate(null);
//		test[1].setId("4");
//		String lastUpdate = "0" + "7-20-2015  8:07:11 PM";
//		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  HH:mm:ss a");
//		Date utilDate1 = sdf.parse(lastUpdate);
//		Date lastUpdateDt =new Date(utilDate1.getTime());
//		test[1].setDate(lastUpdateDt);
//		for (int i = 0; i < 2; i++)
//			System.out.println(test[i].toString());
//	}
	
	public static void main(String[] args) throws Exception
	{
		Test test1 = new Test();
		Test test2 = new Test();
		Test[] test = {test1, test2};
		test[0].setId("3");
		test[0].setDate(null);
		test[1].setId("4");
		String lastUpdate = "0" + "07-20-2015  8:07:11 PM";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss a");
		Date utilDate1 = sdf.parse(lastUpdate);
		Date lastUpdateDt = new Date(utilDate1.getTime());
		test[1].setDate(lastUpdateDt);
		
		for (int i = 0; i < 2; i++)
			System.out.println(test[i].toString());
	}
}
