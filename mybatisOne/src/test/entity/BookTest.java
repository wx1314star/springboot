package entity;

import org.junit.Test;
import service.BookService;
import service.impl.BookServiceImpl;

import java.util.List;

/**
 * Book Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>9月 8, 2020</pre>
 */
public class BookTest {
    private BookService bookService;

    @Test
    public void testWhereAndIf() {
        bookService = new BookServiceImpl();
        //第一种情况：两个参数都为空时，查询所有
        //List<Book> list=bookService.getBookByNameAndAuthor(null,null);
        //第二种情况：姓名为空，作者不为空
        //List<Book> list=bookService.getBookByNameAndAuthor(null,"无名");
        //第三种情况：两个参数都有
        List<Book> list = bookService.getBookByNameAndAuthor("如来神掌", "小名");
        list.forEach(System.out::println);
    }
} 
