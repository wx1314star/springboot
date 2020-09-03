package init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("init/spring.xml");

        //获取工厂中创建好的对象
        UserDao userDao = (UserDao) context.getBean("userDAO");
        System.out.println(userDao);
        userDao.save("xiaocheng");

        CityDao cityDao = (CityDao) context.getBean("cityDAO");
        System.out.println(cityDao);
        cityDao.delete("2");

    }
}
