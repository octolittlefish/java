package javabean;

public class BorrowRecord {

	String BookId;
	String BookName;
	String StartTime;
	String ExpectReturnTime;
	String IsLost;
	String IsBack;
	String debt;
	
	
	public BorrowRecord() {
	}
	public BorrowRecord(String bookId, String bookName, String startTime, String expectReturnTime, 
			String isLost, String isBack, String debt) {
		BookId = bookId;
		BookName = bookName;
		StartTime = startTime;
		ExpectReturnTime = expectReturnTime;
		IsLost = isLost;
		IsBack = isBack;
		this.debt = debt;
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
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getExpectReturnTime() {
		return ExpectReturnTime;
	}
	public void setExpectReturnTime(String expectReturnTime) {
		ExpectReturnTime = expectReturnTime;
	}
	public String getIsLost() {
		return IsLost;
	}
	public void setIsLost(String isLost) {
		IsLost = isLost;
	}
	public String getIsBack() {
		return IsBack;
	}
	public void setIsBack(String isBack) {
		IsBack = isBack;
	}
	public String getDebt() {
		return debt;
	}
	public void setDebt(String debt) {
		this.debt = debt;
	}
	
}
