package com.example.mall.service;

import com.example.mall.vo.CategoryVo;
import com.example.mall.vo.ResponseVo;

import java.util.List;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();
}
