/**
 * CS 202
 * @author Antonio Punzo
 * 11/24/2014
 * Version B
 * Collections Lab
 * @version 2, 11/24/2014
 */

/**
* Class for Customer's Address information
*/
public class Address
{	
	//data members
	/**
	 * Customer's Street
	 */
	private String street;
	/**
	 * Customer's City
	 */
	private String city;
	/**
	 * Customer's State
	 */
	private String state;
	/**
	 * Customer's Postal Code
	 */
	private String postalCode;
	
	//constructors
	/**
	 * default constructor
	 */
	Address()
	{
		
	}
	/**
	 * 
	 * @param street Customer's Street
	 * @param city Customer's City
	 * @param state Customer's State
	 * @param postalCode Customer's Postal Code
	 */
	Address(String street, String city,String state, String postalCode)
	{
		
		this.street=street;
		this.city=city;
		this.state=state;
		this.postalCode=postalCode;
	}
	
	
	// mutator methods, finish
	/**
	 * 
	 * @param street Customer's Street
	 */
	public void setStreet(String street){street=this.street;}
	/**
	 * 
	 * @return Customer's Street
	 */
	public  String getStreet()	{return street;}
	/**
	 * 
	 * @param city Customer's City
	 */
	public void setCity(String city){city=this.city;}
	/**
	 * 
	 * @return Customer's City
	 */
	public  String getCity()	{return city;}
	/**
	 * 
	 * @param state Customer's State
	 */
	public void setState(String state){state=this.state;}
	/**
	 * 
	 * @return Customer's State
	 */
	public  String getState()	{return state;}
	/**
	 * 
	 * @param postalCode Customer's Postal Code
	 */
	public void setPostalCode(String postalCode){postalCode=this.postalCode;}
	/**
	 * 
	 * @return Customer's Postal Code
	 */
	public  String getPostalCode()	{return postalCode;}

	
	// toString method
	/**
	 * @return	Address: Street City, State Postal Code
	 */
	public String toString() {return "Address:"+street+"\n"+city+", "+state+"\n"+postalCode;}
		
}
