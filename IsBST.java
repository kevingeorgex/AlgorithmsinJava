

public class IsBST {

	Node root;
	
	class Node
	{
		int data;
		Node left;
		Node right;
	}
	public static void main(String[] args) {
		IsBST b = new IsBST();
		
		b.checkBST(Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	
	private Boolean checkBST(int minValue, int maxValue) {
		
		return checkBinarySearchTree(root,minValue,maxValue);
	}


	private Boolean checkBinarySearchTree(Node node, int minValue, int maxValue) {

	
		if(node == null)
			return true;
		
		if((node.data<minValue)||node.data>maxValue)
			return false;
		
		return ((checkBinarySearchTree(node.left, minValue, node.data-1))&& checkBinarySearchTree(node.right, node.data+1, maxValue));
		
	}

}
