import java.util.ArrayList;

public class CourseCatalogue {
	
	private ArrayList <Course> courseList;
	
	public CourseCatalogue () {
		loadFromDataBase ();
	}
	
	private void loadFromDataBase() {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());
		
	}
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}
	
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}
	public ArrayList <Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
		for(int i = 0; i<courseList.size(); i++)
		{
			createCourseOffering(courseList.get(i), 1, 100);
			createCourseOffering(courseList.get(i), 2, 100);
		}
	}
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  
			st += "\n";
		}
		return st;
	}

}
