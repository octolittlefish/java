package javabean;

public class Book {
	private String id;
	private String title;
	private String author;
	private String publisher;
	private String pubTime;
	private String isbn;
	private String price;
	private String addTime;
	private boolean isAppoint;
	
	
	public Book(String id, String title, String author, String publisher, String pubTime, String isbn, String price,
			String addTime, boolean isAppoint) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pubTime = pubTime;
		this.isbn = isbn;
		this.price = price;
		this.addTime = addTime;
		this.isAppoint = isAppoint;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public boolean isAppoint() {
		return isAppoint;
	}
	public void setAppoint(boolean isAppoint) {
		this.isAppoint = isAppoint;
	}
}
