package javabean;

public class AppointMessage {

	
	String BookId;
	String BookName;
	String Location;
	int isAppoint;
	
	
	public AppointMessage() {
		super();
	}
	public AppointMessage(String bookId, String bookName, String location, int isAppoint) {
		super();
		BookId = bookId;
		BookName = bookName;
		Location = location;
		this.isAppoint = isAppoint;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getIsAppoint() {
		return isAppoint;
	}
	public void setIsAppoint(int isAppoint) {
		this.isAppoint = isAppoint;
	}
	@Override
	public String toString() {
		return "{\"BookId\":\"" + BookId + "\",\"BookName\":\"" + BookName + "\",\"Location\":\"" + Location
				+ "\",\"isAppoint\":" + isAppoint + "}";
	
	}
	
}
