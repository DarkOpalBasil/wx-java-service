package com.basil.wx.service.impl;

import com.basil.wx.mapper.UsersMapper;
import com.basil.wx.pojo.Users;
import com.basil.wx.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IuserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String openid) {
        return usersMapper.selectByOpenId(openid);
    }

    @Override
    public void register(Users user) {
        usersMapper.insertSelective(user);
    }
}
