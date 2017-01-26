import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

class Node
	{
		int id;
		int amount;
		
		Node(int id,int amount)
		{
			this.id = id;
			this.amount = amount;
		}
		
		@Override
		public String toString() {
		
		return "id :"+id+"amount :"+amount;
		}
	}

public class Experiment {

	static HashMap<Integer,Node> mymap;
	static TreeMap<Integer,Node> mytreemap;
	
	public static void main(String args[])
	{
		LinkedList<Integer> k = new LinkedList<Integer>();
		k.add(5);
		k.add(6);
		k.add(1);
		k.add(2);
		System.out.println(k);
		k.remove();
		System.out.println(k);
		Node n = new Node(1,10);
		mymap = new HashMap<Integer, Node>();
		mytreemap = new TreeMap<Integer, Node>();
		
		mymap.put(1, n);
		mytreemap.put(1, n);
		
		Node x = mymap.get(1);
		x.amount =20;
		System.out.println();
	}
}
