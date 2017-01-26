/*
 * Returns the number of substrings in an input binary string where 0's and 1's are equal
 * 
 * input 1001
 * 
 * output -2 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BinarySubstring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		process(s);
		in.close();
	}

	private static int process(String s) {
		
		Map<String,String> mymap = new HashMap<String,String>();
		
		
		for(int i =0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				if(take(s.substring(i, j)))
				{
					mymap.put(""+i+j, s.substring(i,j));
				}
			}
		}
		return mymap.size();
	}

	private static boolean take(String substring) {
		
		int length = substring.length();
		int violations =0;
		int term =0;
		if(length%2==0)
		{
			for(int i=1;i<length;i++)
			{
				if(substring.charAt(i)!=substring.charAt(i-1))
				{
					violations++;
				}
				
		    }
			
			for(int j=0;j<length;j++)
			{
				if(substring.charAt(j)=='1')
				{
					term = term+1;
				}
				else
				{
					term = term-1;
				}
			}
		
		
		if(violations==1&&term==0)
			return true;
		else
			return false;
		}
		else
		{
			return false;
		}
	}

}
