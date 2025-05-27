package com.basil.wx.service;

import com.basil.wx.pojo.Softmax;

public interface IsoftmaxService {
    Softmax selectById(Integer id);
    Softmax selectByDiseasesId(Integer diseases);
    void insert(Softmax softmax);
    void update(Softmax softmax);
    void deleteById(Integer id);
}
