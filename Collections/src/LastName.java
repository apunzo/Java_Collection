import java.util.Comparator;
/**
 * CS 202
 * @author Antonio Punzo
 * 11/24/2014
 * Version B
 * Collections Lab
 * @version 2, 11/24/2014
 */

/**
 * LastName will get the last name from each customer and sort them in alphabetical order.
 * If the customers have the same last name then they will be ordered by their first names.
 * @author Tony 
 *
 */

public class LastName implements Comparator<Customer>
{
	/**
	 * 
	 */
	
	public int compare(Customer a,Customer b)
	{
		if(a.getLastName().equals(b.getLastName()))
		{return a.getFirstName().compareTo(b.getFirstName());}
		else {return a.getLastName().compareTo(b.getLastName());}
		
	
	}

}
