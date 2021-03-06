package org.codeaction.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：用java语言编写的可重用组件。
 *      javabean >  实体类
 *
 *   它就是创建我们的service和dao对象的。
 *
 *   第一个：需要一个配置文件来配置我们的service和dao
 *           配置的内容：唯一标识=全限定类名（key=value)
 *   第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *   我的配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;
    //定义一个Map,用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String, Object> beans;
    //使用静态代码块为Properties对象赋值
    static {
        try {
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //实例化对象
            props = new Properties();
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的Key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanName = props.getProperty(key);
                //反射创建对象
                Object bean = Class.forName(beanName).newInstance();
                //把key和value存入容器中
                beans.put(key, bean);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化错误");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
