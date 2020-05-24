package org.codeaction.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.codeaction.dao.IRoleDao;
import org.codeaction.dao.IUserDao;
import org.codeaction.domain.Role;
import org.codeaction.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
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
    public void testFindAllRole() throws IOException {
        //使用SqlSession创建Dao接口的代理对象
        IRoleDao roleDao = session.getMapper(IRoleDao.class);
        //使用代理对象执行方法
        List<Role> roles = roleDao.findAll();
        roles.forEach(role -> {
            System.out.println(role);
            role.getUsers().forEach(System.out::println);
        });
    }

    @Test
    public void testFindAllUser() throws Exception {
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        users.forEach(user -> {
            System.out.println(user);
            user.getRoles().forEach(System.out::println);
        });
    }
}
