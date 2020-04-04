
public class Clock {

	private int day;
	private int hour;
	private int minute;
	private int second;
	
	public int getDay() { return day; }
	public int getHour() { return hour; }
	public int getMinute() { return minute; }
	public int getSecond() { return second; }
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setHour(int hour) {
		if( hour < 24) 	this.hour = hour;

		else	System.out.println("Invalid Input");
	}

	
	public void setMinute(int minute) {
		if(minute < 60) 	this.minute = minute;

		else System.out.println("Invalid Input");		
	}
	
	public void setSecond(int second) {
		if(second < 60)	this.second = second;
		
		else	System.out.println("Invalid Input");	
	}
	
	public Clock()
	{
	day = hour = minute = second = 0;
	}
	
	public Clock(int day, int hour, int minute, int second)
	{
	setDay(day);
	setHour(hour);
	setMinute(minute);
	setSecond(second);
	}
	
	 void increment(int second)
	 {
		int tempSec = second%86400%3600%60+getSecond();  
		int tempMin = second%86400%3600/60+getMinute();  
		int tempHour = second%86400/3600+getHour();    
		int tempDay = second/86400+getDay();     
		
		if( tempSec > 59 ) tempMin+=1;
		setSecond(tempSec%60);
		
		if( tempMin > 59 ) tempHour+=1;
		setMinute(tempMin%60);
		
		if(tempHour > 23 ) tempDay+=1;
		setHour(tempHour%24);
		
		setDay(tempDay);	 	 
	 }
	 
	 int calculateTotalSeconds()
	 {
		 int sum = getDay()*86400;
		 sum+= getHour()*3600;
		 sum+= getMinute()*60;
		 sum+= getSecond();
		 return sum;
	 }
	
	
	public static void main(String args[])
	{
	
		// Create elapsed time with the default values of zeros for day, hour,
		// minute and second.
		Clock t1 = new Clock(); // Default constructor
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		// prints: 1:23:59:16
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
		// increments time t1 by 44 seconds:
		t1.increment(44);
		// prints: 2:0:0:0
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d\n", t1.calculateTotalSeconds());
		// REPEAT SIMILAR TESTS FOR t2
		 //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);
		// prints the total elapsed time in seconds: 263045
		System.out.printf("The elapsed time in seconds is: %d\n", t2.calculateTotalSeconds());
		// increments time t2 by 10000 seconds:
		t2.increment(10000);
		// prints: 3:3:50:45
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
		// prints the total elapsed time in seconds: 273045
		System.out.printf("The elapsed time in seconds is: %d\n", t2.calculateTotalSeconds());
			
	}
}
