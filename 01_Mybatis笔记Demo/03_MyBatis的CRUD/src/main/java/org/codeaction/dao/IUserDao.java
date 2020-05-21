package org.codeaction.dao;

import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
    Integer add(User user);
    Integer del(Integer id);
    Integer chg(User user);
    Integer findTotal();
    List<User> findByName(String username);
}
