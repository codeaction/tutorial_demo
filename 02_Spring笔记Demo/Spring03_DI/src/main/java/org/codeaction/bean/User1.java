package org.codeaction.bean;

import java.util.Date;

/**
 * 用户类
 */
public class User1 {
    private String name;
    private Integer age;
    private String address;
    private Date birthday;

    //有参构造方法
    public User1(String name, Integer age, String address, Date birthday) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
