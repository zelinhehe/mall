package com.example.mall.controller;

import com.example.mall.consts.MallConsts;
import com.example.mall.enums.ResponseEnum;
import com.example.mall.form.UserRegisterForm;
import com.example.mall.form.UserLoginForm;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import com.example.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@RestController
//@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userForm,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("注册提交的的参数有误，{} {}",
                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  BindingResult bindingResult,
                                  HttpSession session) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        // 设置session
        session.setAttribute(MallConsts.CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId={}", session.getId());
        return userResponseVo;
    }

    // session 保存在内存中
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        if (user == null) {
            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }

        return ResponseVo.success(user);
    }
}
