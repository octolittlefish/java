package javabean;

public class ExceedMessage {

	String BookId;
	String ReaderId;
	String ReaderName;
	String BookName;
    String StartTime;
    String ExpectReturnTime;
    String DebtDays;
    String Email;
    
    
	public ExceedMessage() {
	}
	public ExceedMessage(String bookId, String readerId, String readerName, String bookName,
			String startTime, String expectReturnTime, String debtDays, String Email) {
		BookId = bookId;
		ReaderId = readerId;
		ReaderName = readerName;
		BookName = bookName;
		StartTime = startTime;
		ExpectReturnTime = expectReturnTime;
		DebtDays = debtDays;
		this.Email = Email;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getReaderId() {
		return ReaderId;
	}
	public void setReaderId(String readerId) {
		ReaderId = readerId;
	}
	public String getReaderName() {
		return ReaderName;
	}
	public void setReaderName(String readerName) {
		ReaderName = readerName;
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
	public String getDebtDays() {
		return DebtDays;
	}
	public void setDebtDays(String debtDays) {
		DebtDays = debtDays;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
    
	@Override
	public String toString() {
		return "{\"BookId\":\""+BookId+"\",\"ReaderId\":\""+ReaderId+"\",\"ReaderName\":\""+ReaderName
				+"\",\"BookName\":\""+BookName+"\",\"StartTime\":\""+StartTime+"\",\"ExpectReturnTime\":\""+ExpectReturnTime
				+"\",\"DebtDays\":\""+DebtDays+"\",\"Email\":\""+Email+"\"}";
	}
}
