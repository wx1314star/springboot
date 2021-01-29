package dao;

import entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    Emp getEmpById(Integer id);

    List<Emp> findAll();

    Emp getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);

    void insert(Emp emp);

    void update(Emp emp);
}
