package com.basil.wx.mapper;

import com.basil.wx.pojo.Softmax;

public interface SoftmaxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Softmax record);

    int insertSelective(Softmax record);

    Softmax selectByPrimaryKey(Integer id);

    Softmax selectByDiseasesId(Integer diseases);

    int updateByPrimaryKeySelective(Softmax record);

    int updateByPrimaryKey(Softmax record);
}