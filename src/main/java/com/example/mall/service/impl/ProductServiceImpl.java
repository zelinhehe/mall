package com.example.mall.service.impl;

import com.example.mall.dao.ProductMapper;
import com.example.mall.pojo.Product;
import com.example.mall.service.ICategoryService;
import com.example.mall.service.IProductService;
import com.example.mall.vo.ProductVo;
import com.example.mall.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdset = new HashSet<>();
        if (categoryId != null) {
            categoryService.findSubCategoryId(categoryId, categoryIdset);
            categoryIdset.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdset);
        List<ProductVo> productVoList = productList
                .stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                }).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }
}
