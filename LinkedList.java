class lnode
{
	int data;
	lnode next;
	
	lnode(int data)
	{
	this.data = data;
	next = null;
	}
}

public class LinkedList {

	static lnode head;
	public static void main(String[] args) {
		int[] myarray = {2,2,3};
		
		for(int i=0;i<myarray.length;i++)
		{
			lnode n = new lnode(myarray[i]);
			insert(n);
		}

		//printnode();
		removeduplicates(head);
		printnode();
	}

	private static lnode removeduplicates(lnode head) {
	
		lnode current = head;
	    
	    if(current.next==null)
	        return head;
	    lnode advanced = current.next;
	    
	    if(advanced.next==null&&current.data==advanced.data)
	    {
	    	current.next = advanced.next;
	    	return head;
	    }
	    
	    while(advanced!=null&&advanced.next!=null)
	        {
	        
	        while(current.data==advanced.data&&advanced.next!=null)
	            {
	            advanced= advanced.next;
	        }
	        if(current.data!=advanced.data)
	            {
	        current.next = advanced;
	        current = advanced;
	        advanced = advanced.next;
	        }
	        else
	            current.next = advanced.next;
	    }
	    
	   return head;
	}

	boolean hasCycle(lnode head) {
		
		lnode slow = head;
		lnode fast = head;
		
		while(slow!=null||fast!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow==fast)
				return true;
		}
		
		return false;
	}
	
	private static void printnode() {
		if(head==null)
			return;
		else
		{
			lnode temp = head;
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
				
		}
		
	}

	private static void insert(lnode n) {
		
		if(head==null)
			head = n;
		else
		{
			lnode temp = head;
			
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next =n;
		}
	}

}
