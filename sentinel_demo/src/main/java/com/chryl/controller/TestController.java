package com.chryl.controller;

import com.chryl.clinet.GoodsClinet;
import com.chryl.core.ex.EnumError;
import com.chryl.core.ex.ResponseException;
import com.chryl.po.ChrGoods;
import com.chryl.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chr.yl on 2020/7/24.
 *
 * @author Chr.yl
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    GoodsClinet goodsClinet;
    @Autowired
    DemoService demoService;

    @GetMapping("/show")
    public Object show() {
        ChrGoods chrGoods = new ChrGoods();
        chrGoods.setGoodsId(2);
        return goodsClinet.getGood(chrGoods);
    }

    @GetMapping("/time")
    public Object time() throws ResponseException {
        if (1 == 1) {
            throw new ResponseException(EnumError.UNKNOW_ERROR);
        }
        return null;
    }

    //测试 sentinel   ================================================================================
    @GetMapping("/show1")
    public Object show1() {
//        demoService.message();
        return "message1";
    }

    @GetMapping("/show2")
    public Object show2() {
//        demoService.message();
        return "message2";
    }
}
