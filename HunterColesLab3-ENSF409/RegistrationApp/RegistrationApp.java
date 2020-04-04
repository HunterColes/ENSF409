import java.io.*;

public class RegistrationApp {
	
	public static void pressEnter() throws IOException
	{
		System.out.println("\nPress 1 to return to the menu");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = "2";
		while(Integer.parseInt(name)!=1)
		name = reader.readLine(); 
	
	}
	
	public static void main (String [] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CourseCatalogue cat = new CourseCatalogue ();
		Student st = new Student ("Sara", 1);
		Student st2 = new Student ("Sam", 2);
		Registration reg = new Registration ();
		Course myCourse = cat.searchCat("ENGG", 233);
		
		reg.completeRegistration(st, myCourse.getCourseOfferingAt(0));
		CourseOffering creg = reg.getTheOffering();
		
		creg.addStud(st);
		creg.addStud(st2);
		

		while(true)
		{
			System.out.println("\n1.  Search Catalouge Courses");
			System.out.println("\n2.  Add Course to Student Courses");
			System.out.println("\n3.  Remove Course from Student Courses");
			System.out.println("\n4.  View All Courses in Catalogue");
			System.out.println("\n5.  View All Courses Taken by Student");
			System.out.println("\n6.  Quit");
			
			
			String s1 = reader.readLine(); 	
			
		switch(Integer.parseInt(s1)) {
		  case 1:
			  System.out.println("Please enter a Course Name:");
			  s1 = reader.readLine();
			  System.out.println("Please enter the course number: ");
			  String s2 = reader.readLine(); 
			  Course c = cat.searchCat(s1,Integer.parseInt(s2));
			  if(c!=null)
			  System.out.println(c);
			  pressEnter();
			  
		    break;
		    
		  case 2:
			  System.out.println("Please enter a Course Name:");
			  s1 = reader.readLine();
			  System.out.println("Please enter the course number: ");
			  s2 = reader.readLine(); 
			  c = cat.searchCat(s1,Integer.parseInt(s2));
			  System.out.println("Please enter the section you would like: ");
			  String s3 = reader.readLine(); 
			  System.out.println("Please enter a Student Name:");
			  s1 = reader.readLine();
			  System.out.println("Please enter the Student ID: ");
			  s2 = reader.readLine(); 
			  
			  creg.register(c,s1,Integer.parseInt(s2),Integer.parseInt(s3));
			  
			  
			  pressEnter();
			  
		    break;
		    case 3:
		    	System.out.println("Please enter a Course Name:");
				  s1 = reader.readLine();
				  System.out.println("Please enter the course number: ");
				  s2 = reader.readLine(); 
				  c = cat.searchCat(s1,Integer.parseInt(s2));
				  System.out.println("Please enter the section you would like: ");
				  s3 = reader.readLine(); 
				  System.out.println("Please enter a Student Name:");
				  s1 = reader.readLine();
				  System.out.println("Please enter the Student ID: ");
				  s2 = reader.readLine(); 
				  
				  creg.unregister(c,s1,Integer.parseInt(s2),Integer.parseInt(s3));
			  pressEnter();
			  
			break;
		  case 4:
			  System.out.println(cat);
			  pressEnter();
			  
			break;
		  case 5:
			  System.out.println("Please enter a Student Name:");
			  s1 = reader.readLine();
			  System.out.println("Please enter the Student ID: ");
			  s2 = reader.readLine();
			  Student a = creg.studSearch(s1,Integer.parseInt(s2));
			  st.printReg(a);
			  pressEnter();
			  
			break;
		  case 6:
			System.out.println("Program Terminated");
			System.exit(1); 
			break;
		}	
	}

	}
}

