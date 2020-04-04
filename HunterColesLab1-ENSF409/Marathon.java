import java.util.ArrayList;
import java.util.Scanner;

public class Marathon {
	
	private ArrayList <String> name = new ArrayList <String> ();
	private ArrayList <Integer> time = new ArrayList <Integer> ();
	
	
	public String getName(int i) {
		return name.get(i);
	}

	public void setName(String i) {
		name.add(i);
	}

	public int getTime(int i) {
		return time.get(i);
	}

	public void setTime(int i) {
		time.add(i);
	}



	public int findFastestRunner()
	{
		int fast = 1000;
		int index = 0;
		for(int i = 0 ; i<name.size() ; i++)
		{
			if(fast > time.get(i))
			{
				fast = time.get(i);
				index = i;
			}
		}
		return index;
	}
	
	
	
	public static void main (String[] args)
	
	{
		Marathon race = new Marathon();
		String sin;
		Scanner scan = new Scanner(System.in);
		while (true)
		{
		System.out.println("Please enter the name of the participant");
		sin = scan.nextLine();
		if(sin.toUpperCase().equals("QUIT"))
		break;
		
		race.setName(sin);
		
		System.out.println("Please enter the running time of the participant");
		sin = scan.nextLine();
		
	    race.setTime(Integer.parseInt(sin));
		}
		int index = race.findFastestRunner();
		
		System.out.println(race.getName(index) + " was the fastest runner, with a time of: "
				+ race.getTime(index) + " seconds");
	}
}



