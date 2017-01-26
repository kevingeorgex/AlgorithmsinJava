
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/*
 * input
 * 3
{[()]}
{[(])}
{{[[(())]]}}

output
YES
NO
YES

 */
public class Valid_Parentheses {

	static Map<Character,Character> mymap;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		 Scanner in = new Scanner(System.in);
	        int numberofstrings = in.nextInt();
	        
	        mymap = new HashMap<Character,Character>();
	        
	        mymap.put('(', ')');
	        mymap.put('{', '}');
	        mymap.put('[', ']');
	        
	        for (int i = 0; i < numberofstrings ; i++) {
	            String expression = in.next();
	            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
	            
	        } 
	        in.close();
	}
	       
	       


	private static boolean isBalanced(String expression) {
	
		Stack<Character> mystack = new Stack<Character>();
		for(char c:expression.toCharArray())
		{
			if(mymap.keySet().contains(c))
			{
				mystack.push(c);
			}
			else if(mymap.values().contains(c))
			{
				if(!mystack.isEmpty()&&mymap.get(mystack.peek())==c)
				mystack.pop();
				else
					return false;
			}
		}
		if(mystack.isEmpty())
		return true;
		else
			return false;
	}
}