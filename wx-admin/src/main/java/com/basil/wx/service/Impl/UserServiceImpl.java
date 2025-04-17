package com.basil.wx.service.Impl;

import com.basil.wx.mapper.UsersMapper;
import com.basil.wx.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IuserService {
    @Autowired
    private UsersMapper usersMapper;

}
