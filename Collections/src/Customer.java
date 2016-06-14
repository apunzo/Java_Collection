import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
 * Receives Detail from Driver for a Customer
 * Get's Address from Address Class
 * @author Tony
 *
 */

public class Customer 
{
		//data members
		/**
		 * Customer's first name
		 */
		protected String firstName;
		/**
		 * Customer's last name
		 */
		protected String lastName;
		/**
		 * Creates new instance of Address for Customer's Address
		 */
		protected Address customerAddress=new Address();
		
		/**
		 * Customer's rating
		 */
		
		public int rating;
		/**
		 * Customer's Credit Rating
		 * @return customer's rating
		 */
		public int creditRating()
		{
			
			return rating;
			
			
		}
		/**
		 * Create link for Customer
		 */
		
		public Customer link;
		
		
		
		
		
		
		//constructors
		/**
		 * Default Constructor
		 */
		Customer()
		{
			
		}
		/**
		 * 
		 * @param firstName Customer's first name
		 * @param lastName Customer's last name
		 * @param customerAddress Customer's Address
		 * @param creditRating Customer's Credit Rating Score
		 */
		Customer(String firstName,String lastName, Address customerAddress, int rating) //creditRating)
		{
			this.firstName=firstName;
			this.lastName=lastName;
			this.customerAddress=customerAddress;
			this.rating=rating;
			
		}
		
		
		// mutator methods, finish
		/**
		 * 
		 * @param firstName Customer's first name
		 */
		protected void setFirstName(String firstName){firstName=this.firstName;}
		/**
		 * 
		 * @param lastName Customer's last name
		 */
		
		protected void setLastName(String lastName){lastName=this.lastName;}
		/**
		 * 
		 * @return Customer's first name
		 */
		protected  String getFirstName()	{return firstName;}
		/**
		 * 
		 * @return Customer's last name
		 */
		protected  String getLastName()	{return lastName;}
		
		
		/**
		 * set Customer's Address
		 */
		protected void setAddress(){customerAddress=this.customerAddress;}
		/**
		 * 
		 * @return Customer's Address
		 */
		protected Address getAddress()	{return customerAddress;}
		
		
		
		/**
		 * 
		 * @param x object to be compared to
		 * @return last name in order
		 */
		public int compareTo(Customer x) {
			
			if(this.getLastName().equals(x.getLastName()))
				return this.getFirstName().compareTo(x.getFirstName());
			else
				return this.getLastName().compareTo(x.getLastName());
		}
		
		public boolean equals(PersonalCustomer x)
		{
			
			if( this.getLastName()==x.getLastName())
			{
				return true;
				
			}
			else
			{
				return false;
			}		
		}
		
	
				
		
		

		// toString method
		
		
		/**
		 * @return Customer: first name,last name, Address, Credit Rating:, Customer's Credit Rating Score
		 */
		
		public String toString() 
		{
			return "Customer:\n"+"First Name: "+firstName+"\n"+"Last Name: "+lastName+"\n"+customerAddress+"\nCustomer's Credit Rating:"+creditRating();
			// TODO Auto-generated method stub
		}
		
}
