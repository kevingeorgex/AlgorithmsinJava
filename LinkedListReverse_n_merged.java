import java.util.Stack;

/*
 * 1-2-3-4-5-6-7
 * print as 7-1-6-2-5-3-4
 */
class LinkedNode{
	
	int data;
	LinkedNode next;
	
	LinkedNode(int data)
	{
		this.data = data;
		next = null;
	}
	
	@Override
	public String toString() {
		
		return ""+data;
	}
}

public class LinkedListReverse_n_merged {

	public static void main(String[] args) {
		
		LinkedNode n = new LinkedNode(1);
		LinkedNode head = n;
		n.next = new LinkedNode(2);
		n.next.next = new LinkedNode(3);
		n.next.next.next = new LinkedNode(4);
		n.next.next.next.next = new LinkedNode(5);
		n.next.next.next.next.next = new LinkedNode(6);
		n.next.next.next.next.next.next = new LinkedNode(7);
		int numberofnodes =0 ;
		
		while(n!=null)
		{
			numberofnodes++;
			n=n.next;
		}
		
		int half = numberofnodes/2;
		
		n = head;
		for(int i =0;i<half;i++)
		{
			n = n.next;
		}
		
		LinkedNode current = reverse(n);
		
		LinkedNode reversehead = current;
		LinkedNode advanced = current.next;
		
		LinkedNode normalcurrent = head;
		LinkedNode normaladvanced = normalcurrent.next;
		
		while(normaladvanced!=null)
		{
			current.next = normalcurrent;
			normalcurrent.next = advanced;
			current = advanced;
			normalcurrent = normaladvanced;
			advanced = advanced.next;
			normaladvanced = normaladvanced.next;
		}
		
		current.next = normalcurrent;
		normalcurrent.next = advanced;
		
		
		LinkedNode temp = reversehead;
		
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static LinkedNode reverse(LinkedNode n) {
		
		LinkedNode current = n;
		LinkedNode advanced = n.next;
		LinkedNode prev = null;
		
		
		while(advanced!=null)
		{
			current.next = prev;
			prev = current;
			current = advanced;
			advanced = advanced.next;
		}
		
		current.next = prev;
		
		return current;
			
	}
}
