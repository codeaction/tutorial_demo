package org.codeaction.dao;

import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有User
    List<User> findAll();
}
