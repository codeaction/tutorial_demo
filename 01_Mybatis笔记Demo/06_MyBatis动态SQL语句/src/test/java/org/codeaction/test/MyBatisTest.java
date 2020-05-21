package org.codeaction.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.codeaction.dao.IUserDao;
import org.codeaction.domain.QueryVo;
import org.codeaction.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private InputStream in;
    private SqlSession session;

    @Before
    public void init() throws IOException {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSession对象
        session = factory.openSession();
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        //释放资源
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        //使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> list = userDao.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testFindById() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(41);

        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception {
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findByName("%王%");

        users.forEach(System.out::println);
    }

    @Test
    public void testFindTotal() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer count = userDao.findTotal();
        System.out.println(count);
    }

    @Test
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> list = userDao.findUserByVo(vo);

        list.forEach(System.out::println);
    }

    @Test
    public void testFindByCondition() {
        User user = new User();
        user.setUsername("老王");
        user.setSex("女");

        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> list = userDao.findByCondition(user);

        list.forEach(System.out::println);
    }

    @Test
    public void testFindUserByIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        for (int i = 41; i <= 50; i++) {
            ids.add(i);
        }

        vo.setIds(ids);

        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> list = userDao.findUserByIds(vo);

        list.forEach(System.out::println);
    }
}
