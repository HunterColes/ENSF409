import java.io.IOException;

public class Shop {

	private Inventory invent;
	private SupplierList sList;
	private Order ord;
	
	public Shop() throws IOException 
	{
		invent = new Inventory();
		sList = new SupplierList();
		ord = new Order();
		
	}
	
	public SupplierList getsList() {
		return sList;
	}

	public Inventory getInvent() {
		return invent;
	}
	/**
	 * calls Inventory"s print function and SupplierList's
	 * print function
	 */
	public void print()
	{
		int buisID;
		for(int i = 0;i < invent.size(); i++)
		{
			buisID = invent.print(i);
			sList.print(buisID);
		}
	}
	/**
	 * creates refrence item and supplier to pass to order class function
	 * @param iD ordered
	 * @param order amount
	 * @param order date
	 * @throws IOException
	 */
	public void order(int iD, int order, String date) throws IOException
	{
		if(invent.order(iD, order, date) == true)
		{
			Item item = invent.stock(iD);
			Supplier sup = sList.order(item);
			ord.order(item, sup, date);
		}
		
		System.out.println("Transcation Complete");
	}
	/**
	 * calls ord.close
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		ord.close();
	}
}

