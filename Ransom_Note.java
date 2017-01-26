import java.util.*;
import java.util.Map.Entry;

public class Ransom_Note {
   Map<String,Integer> magazineMap;
   Map<String,Integer> noteMap;
    
    public Ransom_Note(String magazine, String note) {
        
    	String[] magazineArray = magazine.split(" ");
    	String[] noteMapArray = note.split(" ");
    	
    	magazineMap = new HashMap<String,Integer>();
    	noteMap = new HashMap<String,Integer>();
    	
    	for(String s:magazineArray)
    	{
    		if(magazineMap.containsKey(s))
    		{
    			magazineMap.put(s,(magazineMap.get(s))+1);
    		}
    		else
    		{
    			magazineMap.put(s,1);
    		}
    	}
    	
    	for(String s:noteMapArray)
    	{
    		if(noteMap.containsKey(s))
    		{
    			noteMap.put(s,(noteMap.get(s))+1);
    		}
    		else
    		{
    			noteMap.put(s,1);
    		}
    	}
    	
    }
    
    public boolean solve() {
        
    	boolean flag = true;
    	for(Entry<String, Integer> e:noteMap.entrySet())
    	{
    		if(!magazineMap.containsKey(e.getKey()))
    		{
    			flag = false;
    			break;
    		}
    		
    		if(magazineMap.get(e.getKey())<e.getValue())
    		{
    			flag = false;
    			break;
    		}
    	}
    	
    	if(flag)
    		return true;
    	else
    		return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Ransom_Note s = new Ransom_Note(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
