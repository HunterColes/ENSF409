
public class Item {

	private int itemID;
	private String name;
	private int quantity;
	private double price;
	private int supplier;
	
	public Item(int itemID, String name, int quantity, double price, int supplier)
	{
		setItemID(itemID);
		setName(name);
		setQuantity(quantity);
		setPrice(price);
		setSupplier(supplier);
	}
	
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSupplier() {
		return supplier;
	}
	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}
	/**
	 * print used for single item look up
	 */
	public void print()
	{
		System.out.println("Item ID: "+ getItemID());
		System.out.println("Item Name: "+getName());
		System.out.println("In Stock: "+getQuantity());
		System.out.println("Price: "+ getPrice());
		System.out.println("Supplier: "+ getSupplier());
	}
	
	
}
