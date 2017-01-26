import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/*
 * Input : 2 strings
 * cde
   abc
   output 4
	
	Explanation 
	We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
 */
public class Making_Anagrams {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        String a = in.next();
	        String b = in.next();
	        System.out.println(numberNeeded(a, b));
	        in.close();
	}

	private static int numberNeeded(String a, String b) {
	
		List<Character> firstlist = new ArrayList<Character>();
		List<Character> secondlist = new ArrayList<Character>();
		List<Character> thirdlist = new ArrayList<Character>();
		
		
		
		for(char c:a.toCharArray())
		{
			firstlist.add(c);
		}
		
		for(char c:b.toCharArray())
		{
			secondlist.add(c);
		}
		
		thirdlist.addAll(firstlist);
		
		for(Character c:firstlist)
		{
			if(secondlist.contains(c))
			{
				secondlist.remove(c);
				thirdlist.remove(c);
			}
		}
		return thirdlist.size()+secondlist.size();
	}

}
