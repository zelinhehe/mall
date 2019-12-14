package com.example.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserForm {

    // @NotBlank 用于 String 判断空格
    // @NotEmpty 用于集合
    // @NotNull
//    @NotBlank(message = "用户名不能为空")
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
