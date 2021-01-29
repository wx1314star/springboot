package service.impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import utils.MyBatisUtils;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private SqlSession sqlSession;

    @Override
    public void insert(User user) {
        //获得SqlSession对象
        sqlSession = MyBatisUtils.getSqlSession();
        //获得UserDao对象
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.insert(user);
    }
}
