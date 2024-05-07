package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Student implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String studentID;
	private String fullName;
    private LocalDate dateOfBirth;
    private String address;
    private String gender;
    private double mark1;
    private double mark2;
    private double mark3;
	public Student() {
		super();
	}
	public Student(String studentID, String fullName, LocalDate dateOfBirth, String address, String gender,
			double mark1, double mark2, double mark3) {
		super();
		this.studentID = studentID;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getMark1() {
		return mark1;
	}
	public void setMark1(double mark1) {
		this.mark1 = mark1;
	}
	public double getMark2() {
		return mark2;
	}
	public void setMark2(double mark2) {
		this.mark2 = mark2;
	}
	public double getMark3() {
		return mark3;
	}
	public void setMark3(double mark3) {
		this.mark3 = mark3;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, dateOfBirth, fullName, gender, mark1, mark2, mark3, studentID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				&& Double.doubleToLongBits(mark1) == Double.doubleToLongBits(other.mark1)
				&& Double.doubleToLongBits(mark2) == Double.doubleToLongBits(other.mark2)
				&& Double.doubleToLongBits(mark3) == Double.doubleToLongBits(other.mark3)
				&& Objects.equals(studentID, other.studentID);
	}
	
}
