package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //声明配置文件位置
            String resources = "mybatis-config.xml";
            Reader resourceAsReader = Resources.getResourceAsReader(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession session = null;
        if (session == null) {
            session = sqlSessionFactory.openSession();
        }
        return session;
    }

    /**
     * 关闭sqlSession
     */
    public static void close() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 提交事务
     */
    public static void commit() {
        getSqlSession().commit();
        close();
    }

    /**
     * 回滚事务
     */
    public static void rollback() {
        getSqlSession().rollback();
        close();
    }

}
