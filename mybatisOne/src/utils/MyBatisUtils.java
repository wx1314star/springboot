package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    static {
        try {
            //声明配置文件位置
            String resources = "mybatis-config.xml";
            //读取配置文件
            Reader is = Resources.getResourceAsReader(resources);
            //创建sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开数据库连接
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = t.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭数据库连接
     *
     * @return
     */
    public static SqlSession close() {
        SqlSession sqlSession = t.get();
        if (sqlSession != null) {
            sqlSession.close();
            t.remove();
        }
        return sqlSession;
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
