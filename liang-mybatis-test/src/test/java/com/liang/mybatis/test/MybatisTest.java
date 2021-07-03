package com.liang.mybatis.test;

import com.liang.mybatis.core.io.Resources;
import com.liang.mybatis.core.sqlSession.SqlSession;
import com.liang.mybatis.core.sqlSession.SqlSessionFactory;
import com.liang.mybatis.core.sqlSession.SqlSessionFactoryBuilder;
import com.liang.mybatis.test.dao.UserMapper;
import com.liang.mybatis.test.entity.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    @Test
    public void test() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        System.out.println(resourceAsStream.read());
        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }

    @Test
    public void testByStatementId() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId("1111");
        user.setUsername("zhangsan");
        User userDb = sqlSession.selectOne("com.liang.mybatis.test.dao.UserMapper.getOne", user);

        System.out.println(userDb);

        List<Object> objects = sqlSession.selectList("com.liang.mybatis.test.dao.UserMapper.getList");

        System.out.println(objects);

        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }


    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void testGetMapperQuery() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = mapper.getList();

        System.out.println(list);

        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }

    /**
     * 测试新增
     * @throws Exception
     */
    @Test
    public void testGetMapperInsert() throws Exception {

        User user = new User();
        user.setId("333");
        user.setUsername("哈哈哈哈");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int insert = mapper.insert(user);

        System.out.println(insert);

        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }

    /**
     * 测试修改
     * @throws Exception
     */
    @Test
    public void testGetMapperUpdate() throws Exception {
        User user = new User();
        user.setId("333");
        user.setUsername("hahaha");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int update = mapper.update(user);

        System.out.println(update);

        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }

    /**
     * 测试删除
     * @throws Exception
     */
    @Test
    public void testGetMapperDelete() throws Exception {
        User user = new User();
        user.setId("333");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int delete = mapper.delete(user);

        System.out.println(delete);

        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

    }
}
