import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Lucky_Number_8 {

	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        List<Integer> mylist = new ArrayList<Integer>();
	        String number = in.next();
	        for(int i =0;i<n;i++)
	        {
	        	for(int j = i+1;j<=n;j++)
	        	{
	        		mylist.add(Integer.parseInt(number.substring(i, j)));
	        	}
	        }
	        System.out.println(mylist);
	        in.close();
	}

}
