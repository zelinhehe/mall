package com.example.mall.controller;

import com.example.mall.service.IProductService;
import com.example.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                                    @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId, pageNum, pageSize);
    }
}
