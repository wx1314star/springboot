package entity;

import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MyBatisUtils;

import java.util.Date;

public class UserTest {
    private UserService userService;

    @Test
    public void testInsert() {
        userService = new UserServiceImpl();
        User user = new User();
        user.setName("小范");
        user.setAge(null);
        user.setBir(new Date());
        userService.insert(user);
        MyBatisUtils.commit();
        MyBatisUtils.close();
    }
}
