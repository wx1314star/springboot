package entity;

import java.util.Date;

public class Book {
    private Integer id;
    private String name;
    private Date publishDate;
    private Double price;
    private String author;

    public Book() {
    }

    public Book(Integer id, String name, Date publishDate, Double price, String author) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.price = price;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
