import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

/**
 * CS 202
 * @author Antonio Punzo
 * 11/24/2014
 * Version B
 * Collections Lab
 * @version 3, 11/24/2014
 */

/**
 * Receives Detail from Driver for a Personal Customer
 * Inherites from Customer Class
 * @author Tony
 *
 */
public class PersonalCustomer extends Customer
{
	/**
	 * Customer Credit Card Number
	 */
	private long creditCardNumber;
	
	
	public  ArrayList<PersonalCustomer>Roster= new ArrayList<PersonalCustomer>();
	
	//constructor
	/**
	 * Default Constructor
	 */
	PersonalCustomer()
	{
		
	}
	/**
	 * 
	 * @param firstName Personal Customer  first name
	 * @param lastName Personal Customer last name
	 * @param customerAddress Personal Customer Address
	 * @param creditRating Personal Customer Credit Rating
	 * @param creditCardNumber Personal Customer Credit Card Number
	 */
	PersonalCustomer(String firstName,String lastName, Address customerAddress, int rating /**creditRating*/,long creditCardNumber) 
	{
		super(firstName, lastName, customerAddress, rating);//creditRating);
		
		this.creditCardNumber=creditCardNumber;
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param creditCardNumber Personal Customer Credit Card Number
	 */
	public void setCreditCardNumber (long creditCardNumber){creditCardNumber=this.creditCardNumber;}
	/**
	 * 
	 * @return Personal Customer Credit Card Number
	 */
	public long getCreditCardNumber(){return creditCardNumber;}
	
	public void setRoster(ArrayList<PersonalCustomer> Roster){Roster=this.Roster;}
	
	public ArrayList<PersonalCustomer> getRoster(){return Roster;}
	
	
	
	public void readFile(String fileName) 
	{
		
		boolean debug=true;
		Scanner infile = null;
		
		
		
		try
		{
			infile = new Scanner(new FileReader(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}
		
		
		System.out.println("This list has");
		
		
		while (infile.hasNextLine()&& fileName!=null)
		{


			this.firstName=infile.nextLine();
			setFirstName(this.firstName);
			this.lastName=infile.nextLine();
			setLastName(this.lastName);
			String customerStreet1=infile.nextLine();
			String customerCity1=infile.nextLine();
			String customerState1=infile.nextLine();
			String customerZip1=infile.nextLine();
			this.customerAddress=new Address(customerStreet1,customerCity1,customerState1,customerZip1);
			
			this.rating=Integer.parseInt(infile.nextLine());
			this.creditCardNumber=Long.parseLong(infile.nextLine());
			setCreditCardNumber(this.creditCardNumber);
			PersonalCustomer x= new PersonalCustomer(getFirstName(),getLastName(),customerAddress,rating,getCreditCardNumber());
			System.out.println(x);
			}
			
		
			infile.close();
			
		}
	
	
	public void readFile2(String fileName2) 
	{
		
		boolean debug=true;
		Scanner infile2 = null;
		
		
		try
		{
			infile2 = new Scanner(new FileReader(fileName2));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}
		
		
		System.out.println("This list has");

		while (infile2.hasNextLine())
		{


			this.firstName=infile2.nextLine();
			setFirstName(this.firstName);
			this.lastName=infile2.nextLine();
			setLastName(this.lastName);
			String customerStreet1=infile2.nextLine();
			String customerCity1=infile2.nextLine();
			String customerState1=infile2.nextLine();
			String customerZip1=infile2.nextLine();
			this.customerAddress=new Address(customerStreet1,customerCity1,customerState1,customerZip1);
			
			this.rating=Integer.parseInt(infile2.nextLine());
			this.creditCardNumber=Long.parseLong(infile2.nextLine());
			setCreditCardNumber(this.creditCardNumber);
			PersonalCustomer x= new PersonalCustomer(getFirstName(),getLastName(),customerAddress,rating,getCreditCardNumber());
			this.Roster.add(x);

		
		
			//super.compareTo(x);
			//super.equals(x);
//////////////////////////////////////////////////////////////			
			/**if(x.getLastName().equals("Lupoli"))
			{
				RosterOne.remove(x);
			}
			if(x.getFirstName().contains("Becky"))
			{
				
				System.out.println("This List contains Becky");
				
			}*/
//////////////////////////////////////////////////////////////////////////			
		}
		
		infile2.close();
		/**for(int i=0;i<this.Roster.size();i++)
		{
			
			
			System.out.println(this.Roster.get(i));
		}*/
		
			
			
			
		}
		
		
		
	
	
	/**
	 * 
	 * @param x Personal Customer to compare to
	 * @return Credit card numbers in numerical order
	 */
	
	public int compareTo(PersonalCustomer x) 
	{
		super.compareTo(x);
		
		if(this.creditCardNumber==x.creditCardNumber)
		{ return 0;}
			
		else if (this.creditCardNumber<x.creditCardNumber)
		{return -1;}
		else
		{return 1;}
			
	}
	
	/**
	 * 
	 * @param x Personal Customer to be compared
	 * @return true if this Personal Customer's rating equals that Personal Customer's rating. Otherwise return false 
	 */
	public boolean equals(PersonalCustomer x)
	{
		super.equals(x);
		if( this.rating==x.rating)
		{
			return true;
			
		}
		else
		{
			return false;
		}		
	}
	
	
	@Override
	
	/**
	 * @return Customer first name,last name, Customer Address, Customer Credit Rating, Customer Credit Card Number
	 */
	public String toString()
	{return super.toString()+"\nCredit Card Number:"+getCreditCardNumber()+"\n";}

}
