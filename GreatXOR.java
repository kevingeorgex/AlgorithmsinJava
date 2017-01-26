
import java.util.Scanner;


public class GreatXOR {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	  int q = in.nextInt();
      for(int i = 0; i < q; i++){
          long x = in.nextLong();
         check(x);
      }
      
      in.close();
	}

	private static void check(long x) {
	
		int logvalue = (int)Math.floor(Math.log(x)/Math.log(2));
		int diff =  (int)(Math.pow(2, logvalue+1)-x -1);
		System.out.println(diff);
	}

}
