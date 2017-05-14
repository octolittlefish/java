package javabean;

public class Reader {

	String readerId;
	String idCard;
	String readerName;
	String readerPhone;
	String email;

	public Reader() {
		super();
	}

	public Reader(String readerId, String idCard, String readerName, String readerPhone,String email) {
		this.readerId = readerId;
		this.idCard = idCard;
		this.readerName = readerName;
		this.readerPhone = readerPhone;
		this.email = email;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderPhone() {
		return readerPhone;
	}

	public void setReaderPhone(String readerPhone) {
		this.readerPhone = readerPhone;
	}

	@Override
	public String toString() {
		return "{\"readerId\":\"" + readerId + "\",\"idCard\":\"" + idCard + "\",\"readerName\":\"" + readerName
				+ "\",\"readerPhone\":\"" + readerPhone + "\",\"email\":\""+email+"\"" + "}";
	}
}
