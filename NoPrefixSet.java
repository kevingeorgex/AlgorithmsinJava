
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;


class tNode{
	
	char character;
	Map<Character,tNode> children;
	int count;
	boolean flag;
	
	tNode()
	{
	 children = new HashMap<Character, tNode>();	
	 flag = false;
	 count =0;
	}
	
	tNode(char ch)
	{	
		this();
		character = ch;
	}
	
	@Override
	public String toString() {
		
		return " "+this.character;
	}
}

public class NoPrefixSet {

	
	
	public static void main(String[] args) {
		
		
		
		tNode root;
		
		root = new tNode(' ');
		
		NoPrefixSet t = new NoPrefixSet(); 
		
		Scanner in = new Scanner(System.in);
        int numberofqueries = in.nextInt();
        boolean flag = true;
        for(int i = 0; i < numberofqueries; i++)
        {
            String word = in.next();
         	 flag =t.addword(root,word);
     		 if(flag==false)
     		 {
     			 System.out.println(word);
     			 break;
     		 }
        }
        if(flag)
        	System.out.println("GOOD SET");
        		
//	t.dfs(root,"");
		in.close();

	}

	 /*private void findword(tNode root, String contact) {
	
		char ch = contact.charAt(0);
		
		if(contact.length()==0)  // no words matching with the prefix
		{
			System.out.println("0");
			return;
		}
		if(root.children.containsKey(ch))
		{
			if(contact.length()==1)
			{
				System.out.println(calculatecount(root.children.get(ch)));
				return;
			}
			tNode n = root.children.get(ch);
			findword(n,contact.substring(1, contact.length()));
		}
		else    // no words matching. case when contact has more characters
		{
			System.out.println("0");
			return;
		}
	} 

	private int calculatecount(tNode tNode) {
		return tNode.count;
	} */

/*	private void dfs(tNode root,String word){
		
		if(root.flag)
			System.out.println(word+String.valueOf(root.character));
			
			String s = String.valueOf(root.character);
			word = word + s;
			 for(tNode n: root.children.values())
			 {
				dfs(n,word);
			 }
				
		
	} */

	private boolean addword(tNode root,String word) 
	{ 
		if(root.flag==true)
		{
			System.out.println("BAD SET");
			return false;
		}
		if(word.equals(""))
		{
			root.flag =true;
			root.count++;
			return true;
		}
		char ch = word.charAt(0);
		
		
		if(root.children.keySet().contains(word.charAt(0)))
		{
			if(word.length()==1)   // only one letter is remaining and thats already there in trie, return
			{
				tNode n = root.children.get(ch);
				n.flag = true;
				n.count++;
				root.count++;
				if(!n.children.isEmpty())
					{
					System.out.println("BAD SET");
					return false;
					}
			}
			tNode n = root.children.get(ch);
			root.count++;
			return(addword(n,word.substring(1, word.length())));
		}   // new child
		else
		{
			
			tNode n = new tNode(ch);
			root.children.put(ch, n);
			root.count++;
	    	return(addword(n,word.substring(1,word.length())));
				
		}
	}

}

/*
Sample Input

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad

Sample Output

BAD SET
aabcde
*/