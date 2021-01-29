package service.impl;

import dao.EmpDao;
import entity.Emp;
import org.apache.ibatis.session.SqlSession;
import service.EmpService;
import utils.MyBatisUtils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private SqlSession session;
    private EmpDao empDao;

    @Override
    public Emp getEmpById(Integer id) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.getEmpById(id);
    }

    @Override
    public List<Emp> findAll() {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.findAll();
    }

    @Override
    public Emp getEmpByIdAndName(Integer id, String name) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.getEmpByIdAndName(id, name);
    }

    @Override
    public void insert(Emp emp) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        empDao.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        empDao.update(emp);
    }

    @Override
    public int count() {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.count();
    }

    @Override
    public List<Emp> selectPage(Integer pageNo, Integer pageSize) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.selectPage(pageNo, pageSize);
    }

    @Override
    public List<Emp> findLike(String name) {
        session = MyBatisUtils.getSqlSession();
        empDao = session.getMapper(EmpDao.class);
        return empDao.findLike(name);
    }
}
