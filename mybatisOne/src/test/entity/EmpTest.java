package entity;

import dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import service.EmpService;
import service.impl.EmpServiceImpl;
import utils.MyBatisUtils;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Emp Tester.
 *
 * @author wx
 * @version 1.0
 * @since <pre>9月 2, 2020</pre>
 */
public class EmpTest {
    private EmpService empService;

    @Test
    public void testCon() throws Exception {
//        //声明配置文件位置
//        String resources= "mybatis-config.xml";
//        //读取配置文件
//        InputStream is= Resources.getResourceAsStream(resources);
//        //创建sqlSessionFactory
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
//        //获取sqlSession
//        SqlSession session=sessionFactory.openSession();

        //SqlSession session = MyBatisUtils.getSqlSession();

        //System.out.println(session);
        //根据session获得dao
        //EmpDao empDao = session.getMapper(EmpDao.class);

        empService = new EmpServiceImpl();
        //查询单条数据
        Emp emp = empService.getEmpById(1);
        System.out.println(emp);
        //查询所有Emp对象
        //List<Emp> list=empDao.findAll();
        //list.forEach(System.out::println);
        //根据id和name查询Emp对象
        //Emp emp=empDao.getEmpByIdAndName(2,"小三");
        //System.out.println(emp);
        //添加Emp对象
//        Emp emp=new Emp();
//        emp.setName("小七");
//        emp.setAge(18);
//        emp.setBirthday(new Date());
//        empDao.insert(emp);
        //更新Emp对象
//        Emp emp=new Emp();
//        emp.setId(7);
//        emp.setName("小七七七");
//        emp.setAge(18);
//        emp.setBirthday(new Date());
//        empDao.update(emp);
//        List<Emp> list = empService.findAll();
//        list.forEach(System.out::println);
        //session.getConnection().commit();
        //session.close();
        MyBatisUtils.close();
    }

    @Test
    public void testCount() {
        empService = new EmpServiceImpl();
        System.out.println("记录总数为：" + empService.count());
        MyBatisUtils.close();
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (97 + i));
        }
    }

    @Test
    public void testInsertAll() {
        empService = new EmpServiceImpl();
        System.out.println("批量添加数据开始===>");
        Emp emp = null;
        for (int i = 0; i < 26; i++) {
            emp = new Emp();
            emp.setName(String.valueOf((char) (97 + i) + String.valueOf((char) (97 + i))));
            emp.setAge(new Random().nextInt(99));
            emp.setBirthday(new Date());
            empService.insert(emp);
        }
        System.out.println("批量添加数据结束===>");
        MyBatisUtils.commit();
        MyBatisUtils.close();
    }

    @Test
    public void testSelectPage() {
        empService = new EmpServiceImpl();
        List<Emp> list = empService.selectPage(12, 6);
        list.forEach(System.out::println);
        MyBatisUtils.close();
    }

    @Test
    public void testFindLike() {
        empService = new EmpServiceImpl();
        List<Emp> list = empService.findLike("c");
        list.forEach(System.out::println);
        MyBatisUtils.close();
    }
} 
