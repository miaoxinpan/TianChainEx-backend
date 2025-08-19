package com.tzsw.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.tzsw.service.IAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tcex/assets")
public class AssetsController {


    @Autowired
    private IAssetsService assetsService;

    //获取用户资产余额
    @PostMapping("/balances")
    public AjaxResult queryBalances(@RequestParam String currency, int id) {
        return AjaxResult.success("登陆成功");
    }

    /**
     * opt ： 1.冻结资金 2.解冻资金
     * @param
     * @return
     */
    @PostMapping("/modify")
    public AjaxResult modifyFund(@RequestParam  String opt ,int id) {
        return AjaxResult.success("登陆成功");
    }
}
