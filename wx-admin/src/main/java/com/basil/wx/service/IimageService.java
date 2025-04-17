package com.basil.wx.service;

import com.basil.wx.pojo.Image;
import com.basil.wx.pojo.query.ImageQuery;
import com.basil.wx.utils.PageResult;

import java.util.List;

public interface IimageService {
    void addImage(Image image);
    void deleteById(Integer id);
    void updateImage(Image image);
    Image selectById(Integer id);
    List<Image> selectByDiseaseId(Integer diseaseId);
    List<Image> selectByUser(String openId);
    PageResult<Image> selectByPage(ImageQuery imageQuery);
}
