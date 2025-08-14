package com.tzsw.service.impl;

import com.tzsw.mapper.UsersMapper;
import com.tzsw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UsersMapper userMapper;
}
