

public class Book {
	private String name;
	private Author[] author;
	private double price;
	private int qty=0;
	public Book(String name, Author[] author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Book(String name, Author[] author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	public String getName() {
		return name;
	}

	public Author[] getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getAuthorName() {
		String authorName="";
		   for(int i=0;i<author.length;i++)
		   {   
			   String str=(i<author.length-1)?",":"";
			   authorName+=author[i].getName()+str;
;
	}
		   return authorName;
		   
		}
	@Override
	public String toString() {
		String authorinfo="";
		   for(int i=0;i<author.length;i++)
		   {    
			   String str=(i<author.length-1)?",":"";
			   authorinfo+=author[i].toString()+str;
	}
		   
		return "Book [name=" + name + ",authors={ "+authorinfo+ "}, price=" + price + ", qty=" + qty + "]";
	}
}
