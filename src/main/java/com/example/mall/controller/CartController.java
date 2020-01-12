package com.example.mall.controller;

import com.example.mall.form.CartAddForm;
import com.example.mall.vo.CartVo;
import com.example.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class CartController {

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm,
                                  HttpSession session) {
//        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
//        return cartService.add(user.getId(), cartAddForm);
        return null;
    }
}
