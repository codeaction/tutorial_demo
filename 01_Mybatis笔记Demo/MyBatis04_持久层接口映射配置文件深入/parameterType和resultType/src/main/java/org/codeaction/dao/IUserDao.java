package org.codeaction.dao;

import org.apache.ibatis.annotations.Param;
import org.codeaction.domain.QueryVo;
import org.codeaction.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
    List<User> findUserByVo(QueryVo vo);
    Integer findTotal();
}
