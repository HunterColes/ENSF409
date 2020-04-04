import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Order {

	private BufferedWriter writer;
	/**
	 * print function for making orders into the order file
	 * @throws IOException
	 */
	public Order() throws IOException
	{
    writer = new BufferedWriter(new FileWriter("C:\\Users\\hunte\\Desktop\\orders.txt"));
    writer.write("********************************************************");
	}
	public void order(Item item, Supplier sup, String date) throws IOException
	{
		Random rand = new Random(); 
		int dumb = 5;
		   while(dumb < 10000)
			  dumb = rand.nextInt(99999); 
		   		   
		   writer.write("\nOrder ID:                "+dumb);
		   writer.write("\nDate Ordered:            "+date);
		   writer.write("\n");
		   writer.write("\nItem Name:               "+item.getName());
		   writer.write("\nAmount Ordered:          "+(50-item.getQuantity()));
		   writer.write("\nSupplier:                "+sup.getName());
		   writer.write("\n********************************************************");
		 
	}
	
	
	
	
	/**
	 * closes order.txt when program ends
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		writer.close();
	}
	
}
