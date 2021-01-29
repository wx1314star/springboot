package service;

import entity.Emp;

import java.util.List;

public interface EmpService {
    Emp getEmpById(Integer id);

    List<Emp> findAll();

    Emp getEmpByIdAndName(Integer id, String name);

    void insert(Emp emp);

    void update(Emp emp);

    int count();

    List<Emp> selectPage(Integer pageNo, Integer pageSize);

    List<Emp> findLike(String name);
}
