/*
 * Count the number of prime numbers less than a non-negative number, n
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrimeNumbers {

	static List<Integer> primelist;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int range = in.nextInt();
		 primelist = new ArrayList<Integer>();
		
		System.out.println(printprime(range));
		
		
		
		
		in.close();
	}
	private static int printprime(int range) {
		if(range <= 1)
			return 0;
		if(range==2)
			return 1;
		if(range==3)
			return 2;
	
		primelist.add(2);
		primelist.add(3);
		
		for(int i =4;i<range;i++)
		{
			boolean flag = true;
			for(Integer p:primelist)
			{
				if(i%p==0)
				{
					flag = false;
					break;
				}
			}
			
			if(flag)
				primelist.add(i);
		}
		System.out.println(primelist);
		return primelist.size();
		
		
	}

}
