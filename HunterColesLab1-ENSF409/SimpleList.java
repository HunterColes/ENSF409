public class SimpleList {

	private Node headM;
	private Node tempM;
	private int sizeM;
	/**
	 * Default constructor, sets all instance variables to 0 and null
	 */
	public void Simplelist()
	{
		headM = null;
		sizeM = 0;
	}
	/**
	 * a getter function for sizeM
	 * @return sizeM
	 */
	public int size()
	{
		return sizeM;
	}
	/**
	 * Prints out all elements of the linked list
	 */
	public void print()
	{
		tempM = headM;
		while(tempM!=null)
		{
			System.out.printf("%d ",tempM.item);
			tempM = tempM.next;
		}
		System.out.printf("\n");
	}
	/**
	 * creates a new first element
	 * @param n, value set to the added element
	 */
	public void pushFront(int n)
	{
		tempM = headM;
		headM = new Node(n,tempM);
		sizeM++;
	}
	/**
	 * adds an element to the end of the list
	 * @param n, value set to the added element
	 */
	public void pushBack(int n)
	{
		if(headM == null) 
			headM = new Node(n,null);
		else 
		{
			tempM = headM;
			for(int i = 0; i<sizeM-1; i++)
				tempM = tempM.next;
			
			tempM.next = new Node(n,null);
		}
		sizeM++;
	}
	/**
	 * removes the last element of the list
	 */
	public void popBack()
	{
		if(headM==null) return;
		if(headM.next == null)
		{
			headM = null;
			return;
		}
		
		tempM = headM;
		for(int i = 0; i<sizeM-2;i++)
			tempM = tempM.next;
		
		tempM.next = null;
		sizeM--;
	}
	/**
	 *  returns the value of the n-1 Node value
	 * @param element you want the value of
	 * @return nth element of the list
	 */
	public int get(int n)
	{
		if(n<0 || n>=sizeM)
		{
			System.out.println("get index error");
			System.exit(1);
		}
		tempM = headM;
		for(int i = 0 ;i<n; i++)
			tempM = tempM.next;
			
			return tempM.item;
	}
	/**
	 * sets the n-1 Node value to v
	 * @param element location in the list where the added Node will be
	 * @param value of added Node you want
	 */
	public void set(int n,int v)
	{
		if(n<0 || n>=sizeM)
		{
			System.out.println("set index error");
			System.exit(1);
		}
		tempM = headM;
		for(int i = 0 ;i<n; i++)
			tempM = tempM.next;
			
			tempM.item = v;
	}
	/**
	 * removes all Nodes in the list and sets headM to null
	 */
	public void clear()
	{
		headM = null;
		tempM = headM;
		sizeM = 0;
	}
	/**
	 * removes the nth-1 Node in the list
	 * @param the location of the Node you want to remove
	 */
	public void remove(int n)
	{
		if(headM == null || n<0 || n >= sizeM) 
		{
			System.out.println("remove index error");
			System.exit(1);
		}
		
		if(n == 0) 
			headM = headM.next;
		else
		{
		tempM = headM;
		Node del = tempM.next;
		
			for(int i = 0; i<n - 1 ; i++)
			{
				tempM = del;
				del = del.next;
			}
			tempM.next = del.next;	
		}
		sizeM--;
		
	}
	
	
	/**
	 * adds a Node with a value and location
	 * @param the value in the Node you want to add
	 * @param the location of the Node you want to add
	 */
	public void insert(int v, int n)
	{
	   if( n<0 || n> sizeM) 
	   {
		   System.out.println("insert index error");
		   System.exit(1);
	   }
	   
	   if(n==0)
		   pushFront(v);
	   else if(n==sizeM)
		   pushBack(v);
	   else 
	   {
		   Node before = headM;
		   Node after = headM.next;
		   
		   for(int i = 0; i<n-1; i++)
		   {
			   before = after;
			   after = after.next;
		   }
		   Node ins = new Node(v,after);
		   before.next = ins;  
		   sizeM++;
	   }
	}
	
		
	public static void main(String[] args)
	{
		SimpleList list = new SimpleList();
		
		System.out.printf("List just after creation -- is empty\n");
		
        list.pushFront(6);
		list.pushFront(6);
		list.pushFront(42);
		list.pushFront(38);
		
		System.out.printf("\nAfter calling pushFront. list must have: 38 42 6 6\n");
		
		list.print();
		
		
		list.pushBack(99);
		list.pushBack(102);
		list.pushBack(123);
		list.pushBack(12);
		list.set(2, 71);
		
		System.out.printf("\nAfter calling pushBack and set list must have: 38 42 71 6 99 102 123 12\n");
		
		list.print();
		
		list.popBack();
		list.remove(3);
		list.insert(25,0);
		list.insert(47,5);
		
		System.out.printf("\nAfter calls to remove and insert the list must have: 25 38 42 71 99 47 102 123\n");
		
		list.print();
		
		list.remove(0);
	    list.remove(1);
	    list.remove(2);
	    list.remove(3);
	    
	    System.out.printf("\nAfter 6 removes, list must have: 38 71 47 123\n");
	    
	    list.print();
	    
	    list.clear();
	    System.out.printf("\nAfter call to clear, list must be empty:\n");
	   
	    list.print();
		
	    list.pushBack(331);
	    list.pushBack(221);
	    list.pushBack(111);
	    
	    System.out.printf("\nAfter three calls to push_back, list must have: 331, 221, 111\n");
	    
	    list.print();
	    
		int x = list.get(1);		
		System.out.printf("%d \n",x);
 	
	}
	
}