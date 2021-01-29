package service;

import entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookByNameAndAuthor(String name, String author);
}
