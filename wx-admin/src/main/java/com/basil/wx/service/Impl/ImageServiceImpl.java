package com.basil.wx.service.Impl;

import com.basil.wx.mapper.ImageMapper;
import com.basil.wx.pojo.Image;
import com.basil.wx.pojo.query.ImageQuery;
import com.basil.wx.service.IimageService;
import com.basil.wx.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IimageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public void addImage(Image image) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void updateImage(Image image) {

    }

    @Override
    public Image selectById(Integer id) {
        return null;
    }

    @Override
    public List<Image> selectByDiseaseId(Integer diseaseId) {
        return List.of();
    }

    @Override
    public List<Image> selectByUser(String openId) {
        return List.of();
    }

    @Override
    public PageResult<Image> selectByPage(ImageQuery imageQuery) {
        return null;
    }
}
