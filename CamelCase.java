import java.util.Scanner;


public class CamelCase {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        String s = in.next();
	        
	        char[] myarray = s.toCharArray();
	        
	        int j;
	        int count =0;
	        for(int i=0;i<myarray.length;i++)
	        {
	        	j = (int)myarray[i];
	        	if(j<96)
	        		count++;
	        }
	        
	        System.out.println(++count);
	        in.close();
	        
	}

}
