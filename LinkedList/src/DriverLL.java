import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
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
 * Driver will add and remove Customers to the linked list
 * Driver will also read information for new Customers in from a file and add those customers to the linked list
 * Driver will read information for new Customers in from a file and
 * A.Add customers to an ArrayList, One Customer will be removed from the ArrayList, The list will also be searched for a certain name
 * B.Add customers to a LinkedList, One Customer will be added to the begining and the end of the list. 
 * C.The linked list will print the names in alphabetical order and in order by Credit Card Number
 * @author Tony
 *
 */


public class DriverLL 
{
	public static void main(String args[])
	{
		Linked_List one = new Linked_List();
		boolean debug=true;
		Scanner infile = null;
		Scanner infile2=null;

		Address A001=new Address("402 Comst Street","Frederick","MD","21701");
		Address A002=new Address("1407 Rosemont Ave","Frederick","MD","21703");
		Address A003=new Address("3209 Market Street","Frederick","MD","21702");
		Address A004=new Address("455 Weird Street","Frederick","MD","21707");
		Address A005=new Address("3202 Farimont Ave","Frederick","MD","21701");



		one.insert("Angela","Smith",A001, 700,99997777);
		one.insert("Jack","Haynes", A002, 580,44443333);
		one.insert("Peter","Spielberg",A003, 650,22228888);
		one.insert("Chris","Brown", A004, 400,99995555);
		one.insert("Tony","Punzo", A005,710, 44448888);

		one.print_list();

		one.insertAtHead("John","Richardson", A004, 600,44443333);
		one.insertAtHead("Steve","Russell", A002, 580,44443333);
		one.insertAtHead("Chris","Brown", A004, 400,99995555);
		one.print_list();


		System.out.println();
		System.out.println("Jack Removed");
		one.remove("Jack");

		one.print_list();
		System.out.println();
		System.out.println("Remove Angela");

		one.remove("Angela");
		one.print_list();
		System.out.println();
		System.out.println("Remove Peter");
		one.remove("Peter");
		one.print_list();

		System.out.println();
		System.out.println("Remove Chris");
		one.remove("Chris");
		one.print_list();

		try
		{
			infile = new Scanner(new FileReader("./src/CustomerInfo.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}


		int i=0;
		String[] newName=new String[4];
		String[] newLastName=new String[4];
		Address[] newAddress=new Address[4];
		int[] crdScore=new int[4];
		long[] creditNumber=new long[4];

		while (infile.hasNextLine())
		{
			Linked_List two = new Linked_List();

			for(i=0;i<4;i++)
			{


				newName[i]=infile.nextLine();
				newLastName[i]=infile.nextLine();
				String newStreet=infile.nextLine();
				String newCity=infile.nextLine();
				String newState=infile.nextLine();
				String newZip=infile.nextLine();
				newAddress[i]=new Address(newStreet,newCity,newState,newZip);
				crdScore[i]=Integer.parseInt(infile.nextLine());
				creditNumber[i]=Long.parseLong(infile.nextLine());
				two.insert(newName[i],newLastName[i],newAddress[i] , crdScore[i], creditNumber[i]);

			}



			if(debug)
			{
				two.print_list();

			}

		}
		infile.close();

/////////Collections Lab Begins After This Line/////////////////
////////Q.1-5 ArraysList///////////////////////////////////////
		try
		{
			infile = new Scanner(new FileReader("./src/CustomerInfo.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}


		ArrayList<PersonalCustomer>RosterOne=new ArrayList<PersonalCustomer>();
		System.out.println("This list has");

		while (infile.hasNextLine())
		{



			String fstName1=infile.nextLine();
			String lstName1=infile.nextLine();

			String customerStreet1=infile.nextLine();
			String customerCity1=infile.nextLine();
			String customerState1=infile.nextLine();
			String customerZip1=infile.nextLine();
			Address customerAddress1=new Address(customerStreet1,customerCity1,customerState1,customerZip1);
			int customerScore1=0;
			long customerNumber1=0;
			try
			{
				customerScore1=Integer.parseInt(infile.nextLine());
				customerNumber1=Long.parseLong(infile.nextLine());
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an Integer");
			}
			
			PersonalCustomer x= new PersonalCustomer(fstName1,lstName1,customerAddress1,customerScore1,customerNumber1);
			RosterOne.add(x);


			
		
			
		


		}
		
		
		
		
		
		Address Add1=new Address("425 W. Woodard Blvd","Los Angeles","CA","91200");
		PersonalCustomer target=new PersonalCustomer("Ferdus","Maliki",Add1,730,32508667);
		
		Address Add2=new Address("2700 W. Lincoln St.","Madison","WI","53704");
		PersonalCustomer target2=new PersonalCustomer("Seth","Meyers",Add2,680,87657654);
		RosterOne.add(target);
		RosterOne.add(target2);
		for(i=0;i<RosterOne.size();i++)
		{
			
		
			System.out.println(RosterOne.get(i).toString());
			
			
		}
		RosterOne.remove(target);
		
		if(RosterOne.contains(target))
		{
			System.out.println("Target is On List");
		}
		else
		{
			System.out.println("Target is Not on List");
		}
		if(RosterOne.contains(target2))
		{
			System.out.println("Target Two is On List");
		}
		else
		{
			System.out.println("Target Two Not Found");
		}
		
		for( i=0;i<RosterOne.size();i++)
		{
			
		
			System.out.println(RosterOne.get(i).toString());
			
			
		}
		


//////////////////////////////////////////////////////////////////////////
		infile.close();
		

///////////Q.6-9 LinkedList/////////////////////////////
		try
		{
			infile2 = new Scanner(new FileReader("./src/CustomerInfo2.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}			


		System.out.println("This List Has");

		LinkedList<PersonalCustomer>RosterTwo=new LinkedList<PersonalCustomer>();

		while (infile2.hasNextLine())
		{

			String fstName2=infile2.nextLine();
			String lstName2=infile2.nextLine();

			String customerStreet2=infile2.nextLine();
			String customerCity2=infile2.nextLine();
			String customerState2=infile2.nextLine();
			String customerZip2=infile2.nextLine();
			Address customerAddress2=new Address(customerStreet2,customerCity2,customerState2,customerZip2);
			int customerScore2=0;
			long customerNumber2=0;
			try
			{
				customerScore2=Integer.parseInt(infile.nextLine());
				customerNumber2=Long.parseLong(infile.nextLine());
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an Integer");
			}
			
			PersonalCustomer y= new PersonalCustomer(fstName2,lstName2,customerAddress2,customerScore2,customerNumber2);
			RosterTwo.add(y);

		}

		if(debug)
		{
			Address A1=new Address("2700 W. Lincoln St.","Madison","WI","53704");
			PersonalCustomer newCustomer=new PersonalCustomer("Josh","Tesla",A1,680,87657654);
			RosterTwo.addFirst(newCustomer);
			Address A2=new Address("1505 S. Welborn St.","Kansas City","KS","66046");
			PersonalCustomer newCustomer2=new PersonalCustomer("Jane","Stein",A2,600,77652354);
			RosterTwo.addLast(newCustomer2);

			Iterator<PersonalCustomer> listTwo=RosterTwo.iterator();
			while(listTwo.hasNext())
			{
				PersonalCustomer L2=listTwo.next();

				System.out.println(L2);
			}
			LastName customerName=new LastName();
			Collections.sort(RosterTwo,customerName);
			listTwo=RosterTwo.iterator();
			while(listTwo.hasNext())
			{
				Customer aLastName=listTwo.next();
				System.out.println(aLastName.getLastName());

			}
			System.out.println();

			CreditCardNumber customerCrNumber=new CreditCardNumber();
			Collections.sort(RosterTwo,customerCrNumber);
			listTwo=RosterTwo.iterator();
			while(listTwo.hasNext())
			{
				PersonalCustomer aCreditCardNumber=listTwo.next();
				System.out.println(aCreditCardNumber.getCreditCardNumber());

			}


		}
		infile2.close(); 
		
	
		
		
		
		
	
		
		
		
		
	
		
		
		
		
		
		
		



	}
	public void  myPrint()
	{
		for(int i=0;i<ArrayList<>;i++)
		{
			System.out.println(RosterOne.get(i).toString());
		}
	}




}


