package org.codeaction.dao;

import org.apache.ibatis.annotations.*;
import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "id", property = "accounts",
                many = @Many(select = "org.codeaction.dao.IAccountDao.findByUid")
            )
    })
    List<User> findAll();
    @Select("select * from user where id=#{uid}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);
}
