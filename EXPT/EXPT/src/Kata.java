import java.util.HashMap;
import java.util.Map;

 
  public class Kata{
	  public String name;
	  public int id;
	  
	  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	  
  
  
  
//  public class Map{
//	  public User user;
//	  public String addr;
//	  public int mono;
//	  
//	  
//  }
  
//  
// public static String seriesSum(int n) {
//      
//      double sum = 0.0;
//      for (int i = 0; i < n; i++)
//        sum += 1.0 / (1 + 3 * i);
//      
//      return String.format("%.2f", sum);
//      
//    }
  
  public static void main(String[] args) 
  {
	  
	  Kata user = new Kata();
	  user.setId(9);
	  user.setName("dingyu");
	  String num = "";
	  
	  Map<String, String> map = new HashMap<>();
	  map.put("user", user.toString());
	  map.put("season", "spring");
	  map.put(num, "123");
	  
	  System.out.println(map.toString());
  }
}