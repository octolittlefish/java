package javabean;

public class ReserveMessage {

	String appointId;
	String BookId;
	String ReaderName;
	String AppointTime;
	String AppointLastTime;
	String IsSuccess;

	public ReserveMessage() {
		super();
	}

	public ReserveMessage(String appointId, String bookId, String readerName, String appointTime,
			String appointLastTime, String isSuccess) {
		super();
		this.appointId = appointId;
		BookId = bookId;
		ReaderName = readerName;
		AppointTime = appointTime;
		AppointLastTime = appointLastTime;
		IsSuccess = isSuccess;
	}

	public String getAppointId() {
		return appointId;
	}

	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getReaderName() {
		return ReaderName;
	}

	public void setReaderName(String readerName) {
		ReaderName = readerName;
	}

	public String getAppointTime() {
		return AppointTime;
	}

	public void setAppointTime(String appointTime) {
		AppointTime = appointTime;
	}

	public String getAppointLastTime() {
		return AppointLastTime;
	}

	public void setAppointLastTime(String appointLastTime) {
		AppointLastTime = appointLastTime;
	}

	public String getIsSuccess() {
		return IsSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		IsSuccess = isSuccess;
	}

	@Override
	public String toString() {
		return "{\"appointId\":\""+appointId+"\",\"BookId\":\"" + BookId + "\",\"ReaderName\":\"" + ReaderName + "\",\"AppointTime\":\"" + AppointTime
				+ "\",\"AppointLastTime\":\"" + AppointLastTime + "\",\"IsSuccess\":\"" + IsSuccess + "\"}";

	}

}
