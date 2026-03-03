package hh.sof3.bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
// category entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;

    private String name;

    @JsonIgnoreProperties("category")
    // ignoring "category" attribute for all books

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    // linking type is list of books
    private List<Book> books;

    // no-argument construktor
    public Category() {
    }

    // parameterized constructor
    public Category(String name) {
        this.name = name;
    }

    // getters
    public Long getCategoryid() {
        return categoryid;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // setters
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // toString
    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }

}
