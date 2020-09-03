package di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di/spring.xml");

//        DeptDao deptDao=(DeptDao) context.getBean("deptDAO");
//        deptDao.save("华信智原");

        DeptService deptService = (DeptService) context.getBean("deptService");
        deptService.save("华信智原");
    }
}
