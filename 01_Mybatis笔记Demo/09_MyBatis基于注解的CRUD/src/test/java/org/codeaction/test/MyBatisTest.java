package org.codeaction.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.codeaction.dao.IUserDao;
import org.codeaction.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
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
        list.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testFindById() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(41);

        System.out.println(user);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("小李");
        user.setUserSex("男");
        user.setUserAddress("CHN");
        user.setUserBirthday(new Date());

        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.add(user);
        System.out.println(result);
    }

    @Test
    public void testDel() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.del(60);
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(59);
        user.setUserName("小李");
        user.setUserSex("女");
        user.setUserAddress("CHN");
        user.setUserBirthday(new Date());

        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.update(user);
        System.out.println(result);
    }

    @Test
    public void testFindByName() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> list = userDao.findByName("%王%");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindTotal() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer total = userDao.findTotal();
        System.out.println(total);
    }
}
