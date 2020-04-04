
public class Supplier {

	private int supID;
	private String name;
	private String address;
	private String contact;
	
	public Supplier(int supID,String name, String address, String contact)
	{
		setSupID(supID);
		setName(name);
		setAddress(address);
		setContact(contact);
	}
	public int getSupID() {
		return supID;
	}
	public void setSupID(int supID) {
		this.supID = supID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
