package com.chryl.service;

import com.chryl.dao.GoodsDao;
import com.chryl.po.ChrGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chr.yl on 2020/7/24.
 *
 * @author Chr.yl
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;


    public ChrGoods getGoods(ChrGoods chrGoods) {
        return goodsDao.findById(chrGoods.getGoodsId()).get();
    }
}
