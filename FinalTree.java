
public class FinalTree {

	Node currentparent; Node root =null;
	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}
	
	
	
	public static void main(String[] args) {
		FinalTree f = new FinalTree();
		int[] myarray = {10,5,2,8,15,13,20};
		
		for(int i =0;i<myarray.length;i++)
		{
			f.insert(myarray[i]);
		}
		f.inorder();
	//	f.postorder();
	//	f.delete(3);
	//	f.lca(7,10);
		System.out.println();
		f.reverse();
		f.inorder();		// Printing a tree in reverse
							// In order - 2 5 8 10 13 15 20 
	}						// After reversing, In order - 20 15 13 10 8 5 2 



	private void reverse() {
		reverse(root);
		
	}



	private void reverse(Node root) {
	
		
		if(root==null)
			return;
		
		Node temp =root;
		
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		reverse(root.left);
		reverse(root.right);
	}
	


	private void inorder() {
	inorder(root);
		
	}

	private void postorder() {
		postorder(root);
			
		}


	private void inorder(Node root) {
		if(root==null)
			return ;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}

	private void postorder(Node root) {
		if(root==null)
			return ;
		postorder(root.left);
		
		postorder(root.right);
		System.out.print(root.data+" ");
		
	}

	
	  boolean checkBST() {
		
		  Integer lowerbound = Integer.MIN_VALUE;
		  Integer upperbound = Integer.MAX_VALUE;
		  
		return checkBST(root,lowerbound,upperbound);
		  
	        
	    }

/*	private void lca(int i, int j) {
		Node theNode = lca(root,i,j);
		
	} 



	private Node lca(Node root, int i, int j) {
		
		if(root==null)
			return null;
		else if(root.data>i && root.data > j)
		{
			return lca(root.left,i,j);
		}
		else if(root.data<i && root.data < j)
		{
			return lca(root.right,i,j);
		}
		else
			return root;
	}
   */


	private boolean checkBST(Node root, Integer lowerbound, Integer upperbound) {
		if(root == null)
			return true;
		if(root.data<lowerbound||root.data>upperbound)
			return false;
		
		
		return(checkBST(root.left,lowerbound,root.data-1)&&checkBST(root.right,root.data+1,upperbound));
		
	}



	private void delete(int i) {
		
		root = deleteNode(root,i);
	}

	private Node deleteNode(Node parent, int value) {
		if(parent==null)
			return null;
		else if(parent.data>value)
		{
			parent.left = deleteNode(parent.left,value);
		}
		else if(parent.data<value)
		{
			parent.right = deleteNode(parent.right,value);
		}
		else
			{
				if(parent.left!=null && parent.right!= null)
				{
					Node temp = parent;
					Node minRight = minElement(temp.right);
					parent.data = minRight.data;
					parent.right = deleteNode(parent.right,minRight.data);
				}
				else if(parent.left!=null)
				{
					parent = parent.left;
				}
				else if(parent.right!=null)
				{
					parent = parent.right;
				}
				else
					parent =null;
			}
		return parent;
	}



	public Node minElement(Node node)
	{
		if(node.left==null)
			return node;
		else
			return minElement(node.left);
	}

	private void insert(int i) {
		
		 root = insert(root,new Node(i));
		
	}



	private Node insert(Node currentparent, Node node) {
		if(currentparent ==null)
			return node;
		else if(currentparent.data>node.data)
		{
			currentparent.left = insert(currentparent.left,node);
		}
		else if(currentparent.data<node.data)
		{
			currentparent.right = insert(currentparent.right,node);
		}
		return currentparent;
	}

}
