package com.callor.stream.domain;

import java.io.Serializable;

public class BookVO implements Serializable{

	 private String isbn;
	    private String title;
	    private String author;
	    private int price;
	    public String getIsbn() {
	        return isbn;
	    }
	    public void setIsbn(String isbn) {
	        this.isbn = isbn;
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
	    public int getPrice() {
	        return price;
	    }
	    public void setPrice(int price) {
	        this.price = price;
	    }
	    public BookVO(String isbn, String title, String author, int price) {
	        super();
	        this.isbn = isbn;
	        this.title = title;
	        this.author = author;
	        this.price = price;
	    }
	    @Override
	    public String toString() {
	        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	    }


	
	
}
