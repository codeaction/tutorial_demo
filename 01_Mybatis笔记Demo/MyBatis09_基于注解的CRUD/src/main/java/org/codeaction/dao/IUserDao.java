package org.codeaction.dao;

import org.apache.ibatis.annotations.*;
import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    @Results(
        id = "userMap",
        value = {
                @Result(id = true, column = "id", property = "userId"),
                @Result(column = "username", property = "userName"),
                @Result(column = "birthday", property = "userBirthday"),
                @Result(column = "sex", property = "userSex"),
                @Result(column = "address", property = "userAddress")
        }
    )
    List<User> findAll();
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    User findById(Integer id);
    @Select("select * from user where username like #{name}")
    @ResultMap("userMap")
    List<User> findByName(String name);
    @Select("select count(id) from user")
    Integer findTotal();
    @Insert("insert into user(username, birthday, sex, address) " +
            "values(#{userName}, #{userBirthday}, #{userSex}, #{userAddress})")
    @SelectKey(keyColumn = "id",
            keyProperty = "userId",
            resultType = Integer.class,
            before = false,
            statement = {"select last_insert_id()"})
    Integer add(User user);
    @Delete("delete from user where id=#{id}")
    Integer del(Integer id);
    @Update("update user set username=#{userName}, birthday=#{userBirthday}, " +
            "sex=#{userSex}, address=#{userAddress} where id=#{userId}")
    Integer update(User user);
}
