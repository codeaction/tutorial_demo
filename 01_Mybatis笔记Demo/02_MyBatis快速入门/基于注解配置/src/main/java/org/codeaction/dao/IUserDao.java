package org.codeaction.dao;

import org.apache.ibatis.annotations.Select;
import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
