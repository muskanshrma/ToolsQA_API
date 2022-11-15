package Pages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksPojo {

    @JsonProperty("author")
    private String Author;
    @JsonProperty("title")
    private String Book;
    @JsonProperty("publisher")
    private String Publisher;

    public BooksPojo(String title, String author, String publisher) {
        this.Book=title;
        this.Author=author;
        this.Publisher=publisher;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }
    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    @Override
    public String toString() {
        return "Title: " + this.Book + " Author: " + this.Author + " Publisher: " + this.Publisher;
    }
}