/**
 * CS 202
 * @author Antonio Punzo
 * 11/17/2014
 * Version B
 * Linked_List Lab
 * @version 1, 11/17/2014
 */

/**
 * This Application will Use pointers to add nodes to a linked list 
 * It will add customers or remove customers based on the manipulation of the pointers.
 * @author Tony
 *
 */

public class Linked_List 
{
	
	private	PersonalCustomer FRONT, REAR, CURSOR, INSERT, PREVIOUS,insertAtHead;

	/**
	 * Create method Linked_List to keep track of the different pointers for linked list
	 */
	Linked_List()
	{
		FRONT = null;
		REAR = null;
		PREVIOUS = null;
		CURSOR = null;
		insertAtHead=null;
	}

	/**
	 * Creates method insert which will insert different nodes into the linked list
	 * @param n Customer's name
	 * @param cA Customer's Address
	 * @param r Customer's credit rating
	 * @param cCNum Customer's credit rating
	 */
	public void insert(String n,String l, Address cA, int r,long cCNum)
	{
		
		INSERT = new PersonalCustomer(n,l,cA,r,cCNum);
		
		
		
		
		// collect information into INSERT NODE
		
		
		

		if(isEmpty() == true) // first item in List
		{
			INSERT.link = null;
			FRONT = INSERT;
		}
		else // else what?? When would this happen??
		{
			REAR.link = INSERT;
			INSERT.link = null;

		}
		REAR = INSERT;
	}
	/**
	 * Creates method to insert a node at the beginning of the list instead of the end.
	 * @param n Customer's name
	 * @param cA Customer's Address
	 * @param r Customer's credit Rating
	 * @param cCNum Customer's credit card number
	 */
	public void insertAtHead(String n,String l, Address cA, int r,long cCNum)
	{
		insertAtHead = new PersonalCustomer(n,l,cA,r,cCNum);
		if(isEmpty()==true)
		{
			insertAtHead.link=null;
			FRONT=insertAtHead;
			REAR=insertAtHead;
			
		}  
		else
		{	
			insertAtHead.link=FRONT;
			FRONT=insertAtHead;
			
		} 
		
			
			
	}

	/**
	 * Method to search and delete a node in the linked list by name
	 * @param target Customer to be deleted from list
	 */
	public void remove(String target)
	{
		// 3 possible places that NODES can be removed from in the Linked List
		// FRONT, MIDDLE, REAR
		// all 3 condition need to be covered and coded

		// use Traversing to find TARGET
		PREVIOUS = null;

		for(CURSOR = FRONT; CURSOR != null; CURSOR=(PersonalCustomer) CURSOR.link)
				//CURSOR = CURSOR.link)
		{
			if(target.equals(CURSOR.getFirstName()) == true) // match
			{ break; } // function will still continue, CURSOR will
			// mark NODE to be removed
			else { PREVIOUS = CURSOR; }
			// PREVIOUS marks what NODE CURSOR is marking
			// JUST before CURSOR is about to move to the next NODE
		}

		if(CURSOR == null) { return; } // never found a match
		else
		{
			// check each condition FRONT, REAR and MIDDLE
			if((CURSOR == FRONT) &&  (CURSOR == REAR))// TARGET node was the first and ONLY in the list
			{
				FRONT = null; 
				REAR = null; 
				// cursor will be deleted below
			}// why no need for PREVIOUS??
			else if(CURSOR == FRONT) // TARGET node was the first //in the list
			{ FRONT = (PersonalCustomer) FRONT.link; } // moves FRONT up one node, why no need for PREVIOUS??
			else if (CURSOR == REAR) // TARGET node was the //last in the list
			{ // will need PREVIOUS for this one
				PREVIOUS.link = null; // since this node will become //the last in the list
				PREVIOUS = REAR;
			}
			else // TARGET node was the middle of the list
			{ PREVIOUS.link = CURSOR.link; }// will need PREVIOUS also for this one

			CURSOR = null;
		}

	}	

	/**
	 * Method to check if the list is empty
	 * @return false if list has an item, return true if list is empty
	 */
	public boolean isEmpty()
	{
		if ((FRONT == null) && (REAR == null)) { return true; }
		else { return false;}
	}

	/**
	 * Method to print the list to the console
	 */
	public void print_list( )
	{
		// good for only a few nodes in a list

		if(isEmpty() == true)
		{
			System.out.println( "No nodes to display" );
			return;
		}

		System.out.println("This list has:");

		for(CURSOR = FRONT; CURSOR != null; CURSOR = (PersonalCustomer) CURSOR.link)
		{
			System.out.println(CURSOR);
		}

	}
}
