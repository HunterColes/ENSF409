import java.io.*; 
public class FrontEnd {
	/**
	 * Pauses the program until the user enters a 1 and then presses enter.
	 * 
	 * @throws IOException
	 */
	public static void pressEnter() throws IOException
	{
		System.out.println("\nPress 1 to return to the menu");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = "2";
		while(Integer.parseInt(name)!=1)
		name = reader.readLine(); 
	
	}
public static void main(String [] args) throws IOException
	{
		Shop myShop = new Shop();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("\nPress 1 for Tool List");
			System.out.println("\nPress 2 to search by Tool Name");
			System.out.println("\nPress 3 to search by ToolID");
			System.out.println("\nPress 4 to check item in stock");
			System.out.println("\nPress 5 to simulate a sale");
			System.out.println("\nPress 6 to quit");
			
			
			String s1 = reader.readLine(); 	
			
		switch(Integer.parseInt(s1)) {
		  case 1:
			  System.out.print("*******************************************************************************************************************************************************************");
			  myShop.print();
			  System.out.print("\n*******************************************************************************************************************************************************************");
			  pressEnter();
			  
		    break;
		  case 2:
			  System.out.println("Please enter a tool name you would like to search:");
			  s1 = reader.readLine();
			  myShop.getInvent().search(s1);
			  pressEnter();
			  
		    break;
		  case 3:
			  System.out.println("Please enter a toolID you would like to search:");
			  s1 = reader.readLine();
			  myShop.getInvent().search(Integer.parseInt(s1));
			  pressEnter();
			  
			break;
		  case 4:
			  System.out.println("Please enter a toolID for items in stock:");
			  s1 = reader.readLine();
			  myShop.getInvent().stock(Integer.parseInt(s1));
			  pressEnter();
			  
			break;
		  case 5:
			  System.out.println("Please enter a toolID to sell an item:");
			  s1 = reader.readLine();
			  System.out.println("Please enter amount ordered: ");
			  String s2 = reader.readLine(); 	
			  System.out.println("Please enter todays data:");
			  String s3 = reader.readLine(); 
			  
			  myShop.order(Integer.parseInt(s1),Integer.parseInt(s2),s3);
			  pressEnter();
			  
			break;
		  case 6:
			System.out.println("Program Terminated");
			myShop.close();
			System.exit(1);
		}
		
		
		}

		
	}


}
