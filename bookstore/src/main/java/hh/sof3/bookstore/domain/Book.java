package hh.sof3.bookstore.domain;

public class Book {

    private String title;
    private String author;
    private Integer publicationYear;
    private Integer isbn;
    private double price;

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = 0;
        this.price = 0;
    }

    public Book(String title, String author, Integer publicationYear, Integer isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

}
