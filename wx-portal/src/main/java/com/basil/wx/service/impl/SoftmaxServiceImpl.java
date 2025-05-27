package com.basil.wx.service.impl;

import com.basil.wx.mapper.SoftmaxMapper;
import com.basil.wx.pojo.Softmax;
import com.basil.wx.service.IsoftmaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftmaxServiceImpl implements IsoftmaxService {
    @Autowired
    private SoftmaxMapper softmaxMapper;

    @Override
    public Softmax selectById(Integer id) {
        return softmaxMapper.selectByPrimaryKey(id);
    }

    @Override
    public Softmax selectByDiseasesId(Integer diseases) {
        return softmaxMapper.selectByDiseasesId(diseases);
    }

    @Override
    public void insert(Softmax softmax) {
        softmaxMapper.insert(softmax);
    }

    @Override
    public void update(Softmax softmax) {
        softmaxMapper.updateByPrimaryKey(softmax);
    }

    @Override
    public void deleteById(Integer id) {
        softmaxMapper.deleteByPrimaryKey(id);
    }
}
