package com.basil.wx.service.impl;

import com.basil.wx.mapper.ImageMapper;
import com.basil.wx.pojo.Image;
import com.basil.wx.service.IimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IimageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Image selectById(Integer id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Image> selectByDiseaseId(Integer diseaseId) {
        return imageMapper.selectByDiseaseId(diseaseId);
    }

    @Override
    public List<Image> selectByUser(String openId) {
        return imageMapper.selectByUser(openId);
    }

    @Override
    public List<Image> selectAll() {
        return imageMapper.selectAll();
    }

    @Override
    public void insert(Image image) {
        imageMapper.insertSelective(image);
    }

    @Override
    public void updateDisease(Image image, Integer diseaseId) {
        image.setDisease(diseaseId);
        imageMapper.updateByPrimaryKeySelective(image);
    }

    @Override
    public void deleteById(Integer id) {
        Image image = imageMapper.selectByPrimaryKey(id);
        image.setIsDeleted((byte) 1);
        imageMapper.updateByPrimaryKeySelective(image);
    }
}
