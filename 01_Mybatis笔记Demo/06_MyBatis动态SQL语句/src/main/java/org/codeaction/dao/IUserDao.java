package org.codeaction.dao;

import org.codeaction.domain.QueryVo;
import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String username);
    Integer findTotal();
    List<User> findUserByVo(QueryVo vo);
    List<User> findByCondition(User user);
    List<User> findUserByIds(QueryVo vo);
}
