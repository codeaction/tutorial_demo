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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private InputStream in;
    private SqlSession session;

    /**
     *
     * 在所有测试方法运行之前运行，进行初始化操作
     * @throws IOException
     */
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

    /**
     * 在所有测试方法运行之后运行，进行清理操作
     * @throws IOException
     */
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
    public void testFindByName() throws Exception{
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
    public void testAdd() {
        User user = new User();
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("南昌");

        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.add(user);
        System.out.println(user);
        System.out.println(result);
    }

    @Test
    public void testDel() {
        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.del(49);
        System.out.println(result);
    }

    @Test
    public void testChg() {
        User user = new User();
        user.setId(58);
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("长沙");
        IUserDao userDao = session.getMapper(IUserDao.class);
        Integer result = userDao.chg(user);
        System.out.println(result);
    }
}
