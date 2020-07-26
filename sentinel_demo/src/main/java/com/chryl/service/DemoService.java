package com.chryl.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * Created by Chr.yl on 2020/7/26.
 *
 * @author Chr.yl
 */
@Service
public class DemoService {


    @SentinelResource("message")
    public String message() {
        return "message";
    }

}
