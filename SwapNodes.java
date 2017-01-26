
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

class nod{
	int data;
	nod left;
	nod right;
	int depth;
	
	nod(int data)
	{
		this.data = data;
		left = null;
		right = null;
		depth =0;
	}
	
	@Override
	public String toString() {
		
		return data+"";
	}
}

public class SwapNodes {

	static nod root;
	static TreeSet<Integer> depthlist ;
	
	static int maxdepth = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int numberofnodes = in.nextInt();
		
		depthlist = new TreeSet<Integer>();
		
	    root = new nod(1);
		root.depth =1;
		Queue<nod> myqueue = new java.util.LinkedList<nod>();
		myqueue.add(root);
		in.nextLine();
	
		for(int i=0;i<numberofnodes;i++)
		{
			if(!myqueue.isEmpty())
			{
			nod temp = myqueue.poll();
		
			String[] myarray = in.nextLine().split(" ");
			
			if(Integer.parseInt(myarray[0])!=-1)
			{
			nod n = new nod(Integer.parseInt(myarray[0]));
			n.depth = temp.depth +1;
			
			if(n.depth > maxdepth)
			{
				maxdepth = n.depth;
			}
			temp.left = n;
			myqueue.add(n);
			}
			
			if(Integer.parseInt(myarray[1])!=-1)
			{
			nod n1 = new nod(Integer.parseInt(myarray[1]));
			temp.right = n1;
			
			
			
			n1.depth = temp.depth +1;
			if(n1.depth > maxdepth)
			{
				maxdepth = n1.depth;
			}
			myqueue.add(n1);
			}
		  }	 // End if empty 
		}  // End for loop
		
		int numberofqueries = in.nextInt();
		
		for(int i =0; i < numberofqueries;i++)
		{
			take(in.nextInt());
			inorder(root);
			depthlist.clear();
			System.out.println();
		}
		
		in.close();
	}

	private static void take(int depth) {
	   int counter =1;
	   int intialdepth = depth;
		while(depth <= maxdepth)
		{   
			depthlist.add(depth);
			counter ++;
			depth = intialdepth*counter;
		}
		
		process(root,depthlist);
	}

	private static void inorder(nod root) {
		if(root==null)
			return ;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}

	private static void process(nod root,TreeSet<Integer> depthlist) {
	
		if(depthlist.contains(root.depth))
		{
			swapnodes(root);
			if(root.depth == depthlist.last())
			return;
		}
		
		if(root.left!=null)
		{
			process(root.left,depthlist);
		}
		
		if(root.right!=null)
		{
			process(root.right,depthlist);
		}
	}

	private static void swapnodes(nod root) 
	{
		if(root==null)
			return;
		
		nod temp =root;
		
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		
	}

}
