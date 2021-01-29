package service.impl;

import dao.BookDao;
import entity.Book;
import org.apache.ibatis.session.SqlSession;
import service.BookService;
import utils.MyBatisUtils;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private SqlSession sqlSession;

    @Override
    public List<Book> getBookByNameAndAuthor(String name, String author) {
        sqlSession = MyBatisUtils.getSqlSession();
        bookDao = sqlSession.getMapper(BookDao.class);
        return bookDao.getBookByNameAndAuthor(name, author);
    }
}
