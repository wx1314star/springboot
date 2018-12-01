package com.example.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.LearnDao;
import com.example.demo.domain.LearnResource;
import com.example.demo.tools.Page;
import com.example.demo.tools.StringUtil;

/**
 * Dao实现类
 * 
 * @author wx
 *
 *         Dec 1, 2018
 */
@Repository
public class LearnDaoImpl implements LearnDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(LearnResource learnResource) {
		return jdbcTemplate.update("INSERT INTO learn_resource(author,title,url) values(?,?,?) ",
				learnResource.getAuthor(), learnResource.getTitle(), learnResource.getUrl());
	}

	@Override
	public int update(LearnResource learnResource) {
		return jdbcTemplate.update("UPDATE learn_resource SET author=?," + "title=?,url=? where id = ? ", new Object[] {
				learnResource.getAuthor(), learnResource.getTitle(), learnResource.getUrl(), learnResource.getId() });
	}

	@Override
	public int deleteByIds(String ids) {
		return jdbcTemplate.update("DELETE FROM learn_resource WHERE id IN(" + ids + ") ");
	}

	@Override
	public LearnResource queryLearnResouceById(Long id) {
		List<LearnResource> list = jdbcTemplate.query("SELECT * FROM learn_resource WHERE id = ? ", new Object[] { id },
				new BeanPropertyRowMapper(LearnResource.class));
		if (null != list && list.size() > 0) {
			LearnResource learnResource = list.get(0);
			return learnResource;
		} else {
			return null;
		}
	}

	@Override
	public Page queryLearnResourceList(Map<String, Object> params) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM learn_resource WHERE 1=1 ");
		if (!StringUtil.isNull((String) params.get("author"))) {
			sql.append(" AND author LIKE '% ").append((String) params.get("author").toString()).append(" % ");
		}
		if (!StringUtil.isNull((String) params.get("title"))) {
			sql.append(" AND TITLE LIKE '% ").append((String) params.get("title").toString()).append(" % ");
		}
		System.out.println(sql.toString());
		Page page = new Page(sql.toString(), Integer.parseInt(params.get("rows").toString()),
				Integer.parseInt(params.get("page").toString()), jdbcTemplate);
		return page;
	}

}
