package com.chryl.clinet;

import com.chryl.po.ChrGoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Chr.yl on 2020/7/24.
 *
 * @author Chr.yl
 */
@FeignClient(value = "common-api")//注意feign并不支持下划线,默认集成了ribbon
public interface GoodsClinet {

    @PostMapping("/goods/getGoods")
    Object getGood(@RequestBody ChrGoods chrGoods);
}
