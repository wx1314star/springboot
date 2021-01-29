package dao;

import entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmpDao {
    Emp getEmpById(@Param("id") Integer id);

    List<Emp> findAll();

    Emp getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);

    void insert(Emp emp);

    void update(Emp emp);

    int count();

    List<Emp> selectPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    List<Emp> findLike(@Param("name") String name);
}
