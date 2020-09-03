package init;

public class TestUserDao {
    public static void main(String[] args) {

        //创建组件对象
        UserDao userDao = new UserDaoImpl();

        //使用组件对象
        userDao.save("小陈");

        //销毁JVM

    }
}
