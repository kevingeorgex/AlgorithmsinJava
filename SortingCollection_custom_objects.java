/*
 * Program to demonstrate how to use a treeset with custom employee object by implementing comparable and overriding compareto
 * To demonstrate using a collection(arraylist) with custom customer objects by creating a custom comparator class
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class customer  {
	
	int id;
	int amount;
	
	customer(int id,int amount)
	{
		this.id = id;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		
		return "Id: "+id+" Amount: "+amount;
	}

	
	
}

class Employee implements Comparable<Employee>{
	
	int age;
	int salary;
	
	Employee(int age,int salary)
	{
		this.age = age;
		this.salary = salary;
		
	}
	
	public String toString()
	{
		return "Age: "+age+" Salary: "+salary;
	}
	
	

	public int compareTo(Employee e1) {
		if(this.age>e1.age)
			return 1;
		else if(this.age<e1.age)
			return -1;
		else 
		{
			if(this.salary>e1.salary)
				return 1;
			else if(this.salary<e1.salary)
				return -1;
			else
				return 0;
			
		}
			
	}
		
}


/*
 * Sorting based on increasing order of id's
 */
class Customcomparator implements Comparator<customer>
{

	@Override
	public int compare(customer o1, customer o2) {
		if(o1.id>o2.id)
		return 1;
		else if(o1.id<o2.id)
			return -1;
		else
			return 0;
	}
	
}
/*
 * Sorting based on increasing order of amounts
 */
class Customamountcomparator implements Comparator<customer>
{

	@Override
	public int compare(customer o1, customer o2) {
		if(o1.amount>o2.amount)
		return 1;
		else if(o1.amount<o2.amount)
			return -1;
		else{						// if amounts equal then increasing order of id's
			if(o1.id>o2.id)
				return 1;
			else if(o1.id<o2.id)
				return -1;
			else
				return 0;
		}
			
	}
	
}

public class SortingCollection_custom_objects {

	public static void main(String[] args) {
	
		
		customer c1 = new customer(1,10);
		customer c2 = new customer(3,6);
		customer c3 = new customer(3,5);
		
		List<customer> mylist = new ArrayList<customer>();
		List<customer> mylist1 = new ArrayList<customer>();
		mylist.add(c1);
		mylist.add(c2);
		mylist.add(c3);
		
		mylist1.add(c1);
		mylist1.add(c2);
		mylist1.add(c3);
		
		Set<Employee> myset = new TreeSet<Employee>();
		
		Employee e1 = new Employee(1,10);
		Employee e2 = new Employee(3,6);
		Employee e3 = new Employee(3,5);
		
		myset.add(e1);
		myset.add(e2);
		myset.add(e3);
		
		Collections.sort(mylist,new Customcomparator());
		Collections.sort(mylist1,new Customamountcomparator());
		System.out.println(mylist);
		System.out.println(mylist1);
		
		System.out.println(myset);
	}

}
