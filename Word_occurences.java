import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Word_occurences {

	static Map<String,Integer> mymap ;
	
	public static void main(String[] args) {
		String s = null;
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		mymap = new HashMap<String,Integer>();
		
		for(int i=0;i<number;i++)
		{
			s = in.next();
			process(s);
		}
		
		for(Map.Entry<String,Integer> entry: mymap.entrySet())
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		in.close();
	}

	private static void process(String s) {
		if(mymap.containsKey(s))
		{
			int num = mymap.get(s);
			
			mymap.put(s, ++num);
		}
		else
		{
			mymap.put(s, 1);
		}
	}

}
