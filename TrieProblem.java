
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;


class TrieNode{
	
	char character;
	Map<Character,TrieNode> children;
	int count;
	boolean flag;
	
	TrieNode()
	{
	 children = new HashMap<Character, TrieNode>();	
	 flag = false;
	 count =0;
	}
	
	TrieNode(char ch)
	{	
		this();
		character = ch;
	}
	
	@Override
	public String toString() {
		
		return " "+this.character;
	}
}

public class TrieProblem {

	
	
	public static void main(String[] args) {
		
		
		
		TrieNode root;
		
		root = new TrieNode(' ');
		
		TrieProblem t = new TrieProblem(); 
		
		Scanner in = new Scanner(System.in);
        int numberofoperations = in.nextInt();
        for(int i = 0; i < numberofoperations; i++)
        {
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add"))
            {
            	t.addword(root,contact);
            }
            else if(op.equals("find"))
            {
            	t.findword(root,contact);
            }
            		
        }
        		
//	t.dfs(root,"");
		in.close();

	}

	private void findword(TrieNode root, String contact) {
	
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
			TrieNode n = root.children.get(ch);
			findword(n,contact.substring(1, contact.length()));
		}
		else    // no words matching. case when contact has more characters
		{
			System.out.println("0");
			return;
		}
	}

	private int calculatecount(TrieNode trieNode) {
		return trieNode.count;
	}

/*	private void dfs(TrieNode root,String word){
		
		if(root.flag)
			System.out.println(word+String.valueOf(root.character));
			
			String s = String.valueOf(root.character);
			word = word + s;
			 for(TrieNode n: root.children.values())
			 {
				dfs(n,word);
			 }
				
		
	} */

	private int addword(TrieNode root,String word) 
	{ 
		
		char ch = word.charAt(0);
		
		if(root.children.keySet().contains(word.charAt(0)))
		{
			if(word.length()==1)   // only one letter is remaining and thats already there in trie, return
			{
				TrieNode n = root.children.get(ch);
				n.flag = true;
				n.count++;
				root.count++;
				return root.count;
			}
			TrieNode n = root.children.get(ch);
			root.count++;
			addword(n,word.substring(1, word.length()));
		}
		else
		{
			
			TrieNode n = new TrieNode(ch);
			
			root.children.put(ch, n);
			
			if(word.length()==1)
			{
				n.flag = true;
				n.count++;
				root.count++;
				return root.count;
			}
			else{
				root.count++;
				addword(n,word.substring(1,word.length()));
			}
				
		}
		
		return root.count;
	}

}

/*
Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
*/