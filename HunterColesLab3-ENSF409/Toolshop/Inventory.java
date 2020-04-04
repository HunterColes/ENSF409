import java.io.*;
import java.util.ArrayList;

public class Inventory {

	private ArrayList <Item> items;
	/**
	 * Opens file items and inputs them into an ArrayList of type Item
	 * @throws IOException
	 */
	public Inventory() throws IOException
	{
		items = new ArrayList<Item>();
		File file = new File("C:\\Users\\hunte\\Desktop\\items.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		
		  while ((line = reader.readLine()) != null) 
		  {
			String id = "";
			String name = "";
			String quantity = "";
			String price = "";
			String supplier = "";
			int semiCol = 0;
			 			  			
			   for(int i = 0; i<line.length() ; i++)
			  {
				  if(line.charAt(i)== ';') semiCol++;
				   else if(semiCol == 0) id+= line.charAt(i);
				   else if(semiCol == 1) name+= line.charAt(i);
				   else if(semiCol == 2) quantity += line.charAt(i);
				   else if(semiCol == 3) price += line.charAt(i);
				   else if(semiCol == 4) supplier += line.charAt(i);		  
			  }
			  
			  Item a = new Item(Integer.parseInt(id),name,Integer.parseInt(quantity),Double.parseDouble(price),Integer.parseInt(supplier));
			  items.add(a);  
		  } 
	}
	/**
	 * adds a tool to the ArrayList given all inputs
	 * @param itemID
	 * @param name
	 * @param quantity
	 * @param price
	 * @param supplier
	 */
	public void addTool(int itemID, String name, int quantity, double price, int supplier)
	{
		Item a = new Item(itemID, name, quantity, price, supplier);
		items.add(a);
	}

	/**
	 * searches by toolID
	 * @param toolID
	 */
	public void search(int toolID)
	{
		int i;
		for(i = 0; i<items.size(); i++)
			if(items.get(i).getItemID() == toolID) break;
		
		if(i==items.size()) System.out.println("Item DNE");
		else {
			items.get(i).print();
		}
				
	}
	/**
	 * searches by toolName
	 * @param name
	 */
    public void search(String name)
	{
		int i;
		for(i = 0; i<items.size(); i++)
			if(items.get(i).getName().contentEquals(name)) break;
		
		if(i==items.size()) System.out.println("Item DNE");
		else {
			items.get(i).print();
		}
	}
    /**
     * given a tool id, it prints how many are in stock and returns a 
     * reffrence of the item
     * @param toolID
     * @return item
     */
    public Item stock(int toolID)
	{
    	int i;
		for(i = 0; i<items.size(); i++)
			if(items.get(i).getItemID() == toolID) break;
		
		if(i==items.size()) System.out.println("Item DNE");
		else {
			System.out.println();
			System.out.println(items.get(i).getName()+ ", "+ items.get(i).getQuantity() +" in stock");
		}
		return items.get(i);
	
	}
	
	/**
	 * subtracts order amount from amount in stock
	 * and checks if it requires an order
	 * @param ID order
	 * @param amount order
	 * @param date order
	 * @return
	 */
	public boolean order(int id, int order ,String date)
	{
		int i;
		for(i = 0; i< items.size(); i++)
		{
			if(id == items.get(i).getItemID())
			{
			 items.get(i).setQuantity(items.get(i).getQuantity()-order);
			 break;
			}
		
		}
		if(i==items.size()) System.out.println("Item DNE");
		else if(items.get(i).getQuantity() < 40)
				return true;
			
		return false;
	
	}
	/**
	 * @return item lists size
	 */
	public int size() { return items.size(); }
	/**
	 * used to print items contents in a loop
	 * @param i
	 * @return supplier id
	 */
	public int print(int i)
	{
		System.out.printf("\n ID: %d  Name: %-15s  Stock: %4d  Price: $%-6.2f", items.get(i).getItemID() , items.get(i).getName(), items.get(i).getQuantity() , items.get(i).getPrice() );
		return items.get(i).getSupplier();
	}
}
