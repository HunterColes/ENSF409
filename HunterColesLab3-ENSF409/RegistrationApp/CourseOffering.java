import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		studentList = new ArrayList <Student> ();
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	public void addStud(Student a)
	{
		studentList.add(a);
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}
	public void removeRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.remove(registration);
		
	}
	public Student studSearch(String name,int id)
	{
		for(int i = 0; i< studentList.size(); i++)
		{
			if(studentList.get(i).getStudentId() == id) 
				return studentList.get(i);
		}
		displayStudentNotFoundError();
		return null;
	}
	private void displayStudentNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Student was not found!");
		
	}
	public void register(Course c, String name, int id, int sec)
	{
		Registration reg = new Registration ();

		Student stud = studSearch(name,id);
		if(stud == null) return;

		reg.completeRegistration(stud ,c.getCourseOfferingAt(sec-1));
	}
	public void unregister(Course c, String name, int id, int sec)
	{
		Student stud = studSearch(name,id);
		if(stud == null) return;
		
		for(int i = 0 ; i< offeringRegList.size(); i++) {
			if(offeringRegList.get(i).getTheStudent() == stud && offeringRegList.get(i).getTheOffering().getTheCourse() == c)
			{
				offeringRegList.get(i).removeRegistration();
				
			}
		}
	}
	
	
	

}
