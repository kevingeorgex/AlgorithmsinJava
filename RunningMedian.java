
import java.util.*;


public class RunningMedian {

	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int size = in.nextInt();
        int[] myarray = new int[size];
        
        for(int i=0; i < size; i++){
           insertion(myarray,in.nextInt(),i);
           
            System.out.println(findMedian(myarray,i));
        }
        
        in.close();
    }

	private static void insertion(int[] myarray, int number,int i) {
		
		int value =binarysearch(myarray,0,i-1,number);
		for(int counter = i; counter >value; counter --)
		{
			myarray[counter] = myarray[counter-1];
		}
		myarray[value] = number;
	}

	private static int binarysearch(int[] myarray, int lowerbound, int upperbound,int key) 
	{
		if(lowerbound>upperbound)
			return lowerbound;
		int median = (lowerbound+upperbound)/2;
		if(upperbound == lowerbound )
		{
			if(key>myarray[lowerbound])
			return lowerbound+1;
			else
				return lowerbound;
			
		}if(upperbound-lowerbound ==1){
			if(key<myarray[lowerbound])
				return lowerbound;
			else if(key>myarray[upperbound])
			return upperbound+1;
			else
				return upperbound;
		}
		
		else if(myarray[median]>key)
		{
			return binarysearch(myarray,lowerbound,median,key);
		}
		else if(myarray[median]<key)
		{
			return binarysearch(myarray,median,upperbound,key);
		}else
			return median;
		
		
	}

	private static float findMedian(int[] myarray,int i) {
		
		if(i==0)
			return (float)myarray[i];
		if(i%2==0)  // odd size of array
		{
			return (float)myarray[i/2];
		}
		else
		{
			return (float)(myarray[i/2] + myarray[i/2 +1])/2;
		}
	}
}

/*
 * sample Input : 
 * 6
12
4
5
3
8
7 */

/*
 * Sample output
 * 12.0
8.0
5.0
4.5
5.0
6.0
 */
