import java.util.Scanner;
import java.util.Stack;


public class TwoStacks {

	public static class MyQueue<T> {
        Stack<Integer> stackNewestOnTop = new Stack<Integer>();
        Stack<Integer> stackOldestOnTop = new Stack<Integer>();

        public void enqueue(int value) 
        { // Push onto newest stack
         
        	
        	stackNewestOnTop.push(value);
        	
        	
      /*  	if(stackOldestOnTop.isEmpty())
        		stackOldestOnTop.push(value);
        	else if(!stackOldestOnTop.isEmpty()){
        	
        		while(!stackOldestOnTop.isEmpty())
        			{
        				stackNewestOnTop.push(stackOldestOnTop.pop());
        			}
        		
        		stackOldestOnTop.push(value);
        		
        		while(!stackNewestOnTop.isEmpty())
        		{
        			stackOldestOnTop.push(stackNewestOnTop.pop());
        		}
        	} */
        }

        public int peek() {
            flip(); 
        	return stackOldestOnTop.peek();
        }

        public void dequeue() {
            flip();
        	stackOldestOnTop.pop();
    }
        
        
        void flip()
        {
        	if(stackOldestOnTop.isEmpty())
        			{
        				while(!stackNewestOnTop.isEmpty())
        				{
        					stackOldestOnTop.push(stackNewestOnTop.pop());
        				}
        			}
        }
  }	
	public static void main(String[] args) {
	
		 MyQueue<Integer> queue = new MyQueue<Integer>();
	        
	        Scanner scan = new Scanner(System.in);
	        int numberofqueries = scan.nextInt();
	        
	        for (int i = 0; i < numberofqueries; i++) {
	            int operation = scan.nextInt();
	            if (operation == 1) { // enqueue
	                queue.enqueue(scan.nextInt());
	            } else if (operation == 2) { // dequeue
	                queue.dequeue();
	            } else if (operation == 3) { // print/peek
	                System.out.println(queue.peek());
	            }
	        }
	        scan.close();
	}

}

/*
 * Sample input 
 * 10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2

sample output
14
14
*
*/
