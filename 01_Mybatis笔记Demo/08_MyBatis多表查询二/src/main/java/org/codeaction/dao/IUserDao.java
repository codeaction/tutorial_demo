package org.codeaction.dao;

import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
}
