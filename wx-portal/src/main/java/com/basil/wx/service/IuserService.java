package com.basil.wx.service;

import com.basil.wx.pojo.Users;

public interface IuserService {
    Users login(String openid);
    void register(Users user);
}
