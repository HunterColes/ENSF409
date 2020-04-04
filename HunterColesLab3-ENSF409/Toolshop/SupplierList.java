import java.io.*;
import java.util.ArrayList;

public class SupplierList {

	private ArrayList <Supplier> suppliers;
	/**
	 * opens file suppliers and reads then into an arraList of Suppliers
	 * @throws IOException
	 */
	public SupplierList() throws IOException
	{
		suppliers = new ArrayList<Supplier>();
		File file = new File("C:\\Users\\hunte\\Desktop\\suppliers.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		
		  while ((line = reader.readLine()) != null) 
		  {
			String id = "";
			String name = "";
			String address = "";
			String contact = "";
			int semiCol = 0;
			 			  			
			   for(int i = 0; i<line.length() ; i++)
			  {
				  if(line.charAt(i)== ';') semiCol++;
				   else if(semiCol == 0) id+= line.charAt(i);
				   else if(semiCol == 1) name+= line.charAt(i);
				   else if(semiCol == 2) address += line.charAt(i);
				   else if(semiCol == 3) contact += line.charAt(i);	  
			  }
			  
			  Supplier a = new Supplier(Integer.parseInt(id),name,address,contact);
			  suppliers.add(a);  
		  } 
	}
	/**
	 * prints Supplier,Address & Contact
	 * @param iD
	 */
	public void print(int iD)
	{
		int i;
		for(i = 0; i<suppliers.size(); i++)
			if(suppliers.get(i).getSupID() == iD) break;

		System.out.printf(" Supplier: %-30s Address: %-35s  Contact: %s "  , suppliers.get(i).getName(), suppliers.get(i).getAddress() ,suppliers.get(i).getContact() );
	}
	/**
	 * given an item returns a Supplier
	 * @param tiem reffrence
	 * @return
	 */
	public Supplier order(Item a)
	{
		int i;
		for(i = 0; i<suppliers.size(); i++)
			if(suppliers.get(i).getSupID() == a.getSupplier()) break;
		
	   return suppliers.get(i);
	}
	
}
