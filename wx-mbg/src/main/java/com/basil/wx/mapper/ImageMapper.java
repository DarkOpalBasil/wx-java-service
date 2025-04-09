package com.basil.wx.mapper;

import com.basil.wx.pojo.Image;

import java.util.List;

public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    List<Image> selectByDiseaseId(Integer diseaseId);

    List<Image> selectByUser(String openId);

    List<Image> selectAll();

}