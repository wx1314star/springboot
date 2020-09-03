package entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/** 
* Emp Tester. 
* 
* @author wx
* @since <pre>9月 2, 2020</pre> 
* @version 1.0 
*/ 
public class EmpTest { 

    @Test
    public void testCon() throws Exception {
        //声明配置文件位置
        String resources="mybatis-config.xml";
        //读取配置文件
        InputStream is= Resources.getResourceAsStream(resources);
        //创建sqlSessionFactory
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession
        SqlSession session=sessionFactory.openSession();

        System.out.println(session);
        session.getConnection().commit();
    }
} 
