package com.example.mall.service;

import com.example.mall.vo.ProductVo;
import com.example.mall.vo.ResponseVo;

import java.util.List;

public interface IProductService {

    ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
