package com.tzsw.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.R;
import com.tzsw.model.Users;
import com.tzsw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tcex/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     * @param users
     * @return
     */
    @PostMapping("/register")
    public AjaxResult registerUser(@Valid @RequestBody Users users) {
        userService.register(users);
        return AjaxResult.success();
    }

    @PostMapping("/login")
    public AjaxResult login(@Valid @RequestBody Users users) {
        userService.register(users);
        return AjaxResult.success();
    }
}
