package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ListClient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Student> students;
	public ListClient() {
		super();
		this.students = new ArrayList<Student>();
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public boolean existStudent(String id)
	{
		for (Student student : students) {
			if(student.getStudentID().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	public boolean addStudent(Student st)
	{
		if(!existStudent(st.getStudentID()))
		{
			this.students.add(st);
			return true;
		}
		else
		{
			return false;
		}
	}
}
