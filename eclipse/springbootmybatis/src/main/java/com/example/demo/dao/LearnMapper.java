package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.demo.domain.LearnResource;
import com.example.demo.tools.StringUtil;

/**
 * Component注解不添加也没事， 只是不加service那边引入LearnMapper会有错误提示，但不影响
 * 
 * @author wx
 * 
 *         Dec 3, 2018
 */
@Component
@Mapper
public interface LearnMapper {
	@Insert("INSERT INTO learn_resource(author,title,url) VALUES (#{author},#{title},#{url})")
	int add(LearnResource learnResource);

	@Update("UPDATE learn_resource SET author=#{author},title=#{title},url=#{url} WHERE id=#{id}")
	int update(LearnResource learnResource);

	@DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByIds")
	int deleteByIds(@Param("ids") String[] ids);

	@Select("SELECT * FROM learn_resource WHERE id = #{id}")
	@Results(id = "learnMap", value = { @Result(column = "id", property = "id", javaType = Long.class),
			@Result(property = "author", column = "author", javaType = String.class),
			@Result(property = "title", column = "title", javaType = String.class) })
	LearnResource queryLearnResouceById(Long id);

	@SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResourceByParams")
	List<LearnResource> queryLearnResourceList(Map<String, Object> params);

	/**
	 * 内部类写分页查询和删除
	 * 
	 * @author wx
	 *
	 *         Dec 3, 2018
	 */
	class LearnSqlBuilder {
		/**
		 * 多条件查询sql
		 * 
		 * @param params
		 * @return
		 */
		public String queryLearnResourceByParams(final Map<String, Object> params) {
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM learn_resource WHERE 1=1 ");
			if (!StringUtil.isNull((String) params.get("author"))) {
				sb.append("AND author LIKE '%").append((String) params.get("author")).append("%'");
			}
			if (!StringUtil.isNull((String) params.get("title"))) {
				sb.append("AND title LIKE '%").append((String) params.get("title")).append("%'");
			}
			System.out.println("查询SQL=" + sb.toString());
			return sb.toString();
		}

		/**
		 * 删除方法
		 * 
		 * @param ids
		 * @return
		 */
		public String deleteByIds(@Param("ids") final String[] ids) {
			StringBuffer sb = new StringBuffer();
			sb.append("DELETE FROM learn_resource WHERE id in (");
			for (int i = 0; i < ids.length; i++) {
				if (i == ids.length - 1) {
					sb.append(ids[i]);
				} else {
					sb.append(ids[i]).append(",");
				}
			}
			sb.append(")");
			return sb.toString();
		}
	}
}
