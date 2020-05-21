package org.codeaction.dao;

import org.codeaction.domain.Role;

import java.util.List;

public interface IRoleDao {
    List<Role> findAll();
}
