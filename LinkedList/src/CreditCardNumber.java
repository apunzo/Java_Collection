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
 * CreditCardNumber will get Credit card number from each personal customer and sort them based on numerical value.
 * @author Tony
 *
 */

public class CreditCardNumber implements Comparator<PersonalCustomer>
{
	
	public int compare(PersonalCustomer a,PersonalCustomer b)
	{
		if(a.getCreditCardNumber()<b.getCreditCardNumber()){return -1;}
				
		else if(a.getCreditCardNumber()>b.getCreditCardNumber()){return 1;}
		else{return 0;}
	
	}

}
