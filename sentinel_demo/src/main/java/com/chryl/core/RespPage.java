//package com.chryl.core;
//
//import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
//import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
//import com.alibaba.fastjson.JSON;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by Chr.yl on 2020/7/26.
// *
// * @author Chr.yl
// */
//@Component
//public class RespPage implements UrlBlockHandler {
//
//    //只吸收sentinel的BlockException
//    @ExceptionHandler(value = BlockException.class)
//    @Override
//    public void blocked(HttpServletRequest request,
//                        HttpServletResponse response, BlockException e) throws IOException {
//
//        ReturnResult returnResult = new ReturnResult();
//        //BlockException 异常接口, 包含sentinel的五个规则的异常
//        //FlowException 限流异常
//        //DegradeException  降级异常
//        //ParamFlowException    参数限流异常
//        //AuthorityException    授权异常
//        //SystemBlockException  系统负载异常
//        if (e instanceof FlowException) {//限流的
//            returnResult = new ReturnResult("-1", "限流异常");
//        } else if (e instanceof DegradeException) {//降级
//            returnResult = new ReturnResult("-2", "降级异常");
//        } else if (e instanceof ParamFlowException) {
//            returnResult = new ReturnResult("-3", "参数限流异常");
//        } else if (e instanceof AuthorityException) {
//            returnResult = new ReturnResult("-4", "授权异常");
//        } else if (e instanceof SystemBlockException) {
//            returnResult = new ReturnResult("-5", "系统负载异常");
//        }
//        //这里为了方便页面查看,写回到页面,正常直接抛出自定义异常就好,由全局异常捕获
//        response.setContentType("application/json;charset=utf-8");//防止中文乱码
//        response.getWriter().write(JSON.toJSONString(returnResult));//返回页面样式为json格式
//
//    }
//}