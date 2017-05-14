package javabean;

public class ReaderMessage {

	String readerID;
	String idCard;
	String name;
	String phone;

	public ReaderMessage() {
	}

	public ReaderMessage(String readerID, String idCard, String name, String phone) {
		this.readerID = readerID;
		this.idCard = idCard;
		this.name = name;
		this.phone = phone;
	}

	public String getReaderID() {
		return readerID;
	}

	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
