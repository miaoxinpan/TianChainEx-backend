package com.tzsw.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.tzsw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tcex/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/{jobId}")
    public AjaxResult getInfo(@PathVariable("jobId") Long jobId)
    {

        return AjaxResult.success(jobId);
    }
}
