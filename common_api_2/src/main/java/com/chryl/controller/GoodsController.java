package com.chryl.controller;

import com.chryl.po.ChrGoods;
import com.chryl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chr.yl on 2020/7/24.
 *
 * @author Chr.yl
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping("/getGoods")
    public Object getGood(@RequestBody ChrGoods chrGoods) {
        System.out.println(chrGoods);
        chrGoods.setGoodsId(3);
        return goodsService.getGoods(chrGoods);
    }
}
