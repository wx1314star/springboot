<%@ page import="service.impl.BookServiceImpl" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="service.BookService" %><%--
  Created by IntelliJ IDEA.
  User: wx
  Date: 2020/9/2
  Time: 9:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老朱</title>
</head>
<body>
老朱啊
</body>
<%
    BookService bookService = new BookServiceImpl();
    //第一种情况：两个参数都为空时，查询所有
    //List<Book> list=bookService.getBookByNameAndAuthor(null,null);
    //第二种情况：姓名为空，作者不为空
    //List<Book> list=bookService.getBookByNameAndAuthor(null,"无名");
    //第三种情况：两个参数都有
    List<Book> list = bookService.getBookByNameAndAuthor("如来神掌", "小名");
    for (Book book : list) {
        System.out.println(book);
    }
    list.forEach(System.out::println);
%>
<table>

    <tr>

    </tr>
</table>
</html>
