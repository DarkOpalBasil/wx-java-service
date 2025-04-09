package com.basil.wx.service;

import com.basil.wx.pojo.Image;

import java.util.List;

public interface IimageService {
    Image selectById(Integer id);
    List<Image> selectByDiseaseId(Integer diseaseId);
    List<Image> selectByUser(String openId);
    List<Image> selectAll();
    void insert(Image image);
    void updateDisease(Image image, Integer diseaseId);
    void deleteById(Integer id);
}
