package com.example.demo.tools;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 分页工具类
 *
 * @author wx
 * <p>
 * Dec 1, 2018
 */
public class Page {
    // 每页显示的纪录数
    private int numberPage;
    // 记录总数
    private int totalRows;
    // 总页数
    private int totalPages;
    // 当前页码
    private int currentPage;
    // 起始行数
    private int startIndex;
    // 结束行数
    private int lastIndex;
    // 结果集存放List
    private List<Map<String, Object>> resultList;

    /**
     * 分页构造函数
     *
     * @param sql          包含筛选条件的sql，但不包含分页相关约束，如mysql的limit
     * @param numberPage   每页记录数
     * @param currentPage  当前页
     * @param jdbcTemplate jdbcTemplate实例
     */
    public Page(String sql, int numberPage, int currentPage, JdbcTemplate jdbcTemplate) {
        if (null == jdbcTemplate) {
            throw new IllegalArgumentException("Page.jdbcTemplate is null");
        } else if (null == sql || "".equals(sql)) {
            throw new IllegalArgumentException("Page.sql is empty");
        }
        // 设置每页显示记录数
        setNumberPage(numberPage);
        // 设置要显示的页数
        setCurrentPage(currentPage);
        // 计算总记录数
        StringBuffer totalSql = new StringBuffer(" SELECT COUNT(1) FROM ( ");
        totalSql.append(sql);
        totalSql.append(" ) totalTable");
        // 总纪录数
        setTotalRows(jdbcTemplate.queryForObject(totalSql.toString(), Integer.class));
        // 计算总页数
        setTotalPages();
        // 计算起始行数
        setStartIndex();
        // 计算结束行数
        setLastIndex();
        System.out.println("lastIndex=" + lastIndex);
        // 使用mysql时直接使用limits
        StringBuffer paginationSql = new StringBuffer();
        paginationSql.append(sql);
        paginationSql.append(" limit " + startIndex + "," + lastIndex);
        System.out.println("paginationSql=" + paginationSql.toString());
        // 装入结果集
        setResultList(jdbcTemplate.queryForList(paginationSql.toString()));
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 计算总页数
     */
    public void setTotalPages() {
        if (totalRows % numberPage == 0) {
            this.totalPages = totalRows / numberPage;
        } else {
            this.totalPages = (totalRows / numberPage) + 1;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    /**
     * 设置起始索引
     */
    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * numberPage;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    /**
     * 计算结束时候的索引
     */
    public void setLastIndex() {
        System.out.println("totalRows=" + totalRows);
        System.out.println("numberPage=" + numberPage);
        if (totalRows < numberPage) {
            this.lastIndex = totalRows;
        } else if ((totalRows % numberPage == 0) || (totalRows % numberPage != 0 && currentPage < totalPages)) {
            this.lastIndex = currentPage * numberPage;
            // 最后一页
        } else if (totalRows % numberPage != 0 && currentPage == totalPages) {
            this.lastIndex = totalRows;
        }
    }

    public List<Map<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map<String, Object>> resultList) {
        this.resultList = resultList;
    }

}
