package org.codeaction.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.codeaction.bean.Account;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAccountDao {
    @Select("select * from account")
    List<Account> findAll();
}
