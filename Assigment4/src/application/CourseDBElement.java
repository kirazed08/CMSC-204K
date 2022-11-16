package application;

public class CourseDBElement {
	String Id,roomNum, name;
	int crn, credit; 
public CourseDBElement() {
		Id = null;
		crn = -1;
		credit = -1;
		roomNum = null;
		name = null;
	}
	public CourseDBElement(String s, int a, int b, String d, String c) {
		this.Id = s;
		this.crn = a;
		this.credit = b;
		this.name = c;
		this.roomNum = d;
		
	}
	public String getID() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCRN() {
		return crn;
	}
	public void setCRN(int crn) {
		this.crn = crn;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String toString() {
		return "\nCourse:"+Id+" CRN:"+crn+" Credits:"+credit+" Instructor:"+name+" Room:"+roomNum;
	}

}
