package entity;

import dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtils;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Emp Tester.
 *
 * @author wx
 * @version 1.0
 * @since <pre>9月 2, 2020</pre>
 */
public class EmpTest {

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
        SqlSession session = MybatisUtils.getSqlSession();

        //System.out.println(session);
        //根据session获得dao
        EmpDao empDao = session.getMapper(EmpDao.class);
        //查询单条数据
        //Emp emp=empDao.getEmpById(1);
        //System.out.println(emp);
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
        List<Emp> list = empDao.findAll();
        list.forEach(System.out::println);
        MybatisUtils.commit();
        MybatisUtils.close();
        //session.getConnection().commit();
        //session.close();
    }
} 
