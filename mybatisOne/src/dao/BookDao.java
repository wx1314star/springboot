package dao;

import entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    List<Book> getBookByNameAndAuthor(@Param("name") String name, @Param("author") String author);
}
