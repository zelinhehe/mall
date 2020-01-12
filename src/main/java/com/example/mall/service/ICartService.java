package com.example.mall.service;

import com.example.mall.form.CartAddForm;
import com.example.mall.vo.CartVo;
import com.example.mall.vo.ResponseVo;

public interface ICartService {

	ResponseVo<CartVo> add(Integer uid, CartAddForm form);

	ResponseVo<CartVo> list(Integer uid);
}
