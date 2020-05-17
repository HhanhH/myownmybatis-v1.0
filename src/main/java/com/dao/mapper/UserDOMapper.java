package com.dao.mapper;

import com.dao.domain.UserDO;

public interface UserDOMapper {
    UserDO selectOne(Long id);
}
