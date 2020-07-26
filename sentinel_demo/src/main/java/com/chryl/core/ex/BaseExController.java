package com.chryl.core.ex;


import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.chryl.core.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Chr on 2019/5/28.
 */
@Slf4j
//@ControllerAdvice
@RestControllerAdvice
public class BaseExController implements UrlBlockHandler {


    /**
     * 暂时不写 该异常处理 ,因为有的 BlockException 异常 会被他捕捉
     * @param request
     * @param response
     * @param ex
     * @throws IOException
     */
    //定义ExceptionHandler解决未被Controller层吸收的Exception
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handlerException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
//        Map<String, Object> responseData = new HashMap<>();
//        if (ex instanceof ResponseException) {
//            ResponseException responseException = (ResponseException) ex;
//            responseData.put("errorCode", responseException.getErrorCode());
//            responseData.put("errorMessage", responseException.getErrorMessage());
//        } else {
//            responseData.put("errorCode", EnumError.UNKNOW_ERROR.getErrorCode());
//            responseData.put("errorMessage", EnumError.UNKNOW_ERROR.getErrorMessage());
//        }
//        //打印错误信息
//        ex.printStackTrace();
//        //记录日志
//        log.error("BaseController:---:" + ex.getMessage());
//        //返回包装类
//        return ReturnResult.create(responseData, "fail");
//
//    }


    //只吸收sentinel的BlockException
    @ExceptionHandler(value = BlockException.class)
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {

        ReturnResult returnResult = new ReturnResult();
        //BlockException 异常接口, 包含sentinel的五个规则的异常
        //FlowException 限流异常
        //DegradeException  降级异常
        //ParamFlowException    参数限流异常
        //AuthorityException    授权异常
        //SystemBlockException  系统负载异常
        if (ex instanceof FlowException) {//限流的
            returnResult = new ReturnResult("-1", "限流异常");
        } else if (ex instanceof DegradeException) {//降级
            returnResult = new ReturnResult("-2", "降级异常");
        } else if (ex instanceof ParamFlowException) {
            returnResult = new ReturnResult("-3", "参数限流异常");
        } else if (ex instanceof AuthorityException) {
            returnResult = new ReturnResult("-4", "授权异常");
        } else if (ex instanceof SystemBlockException) {
            returnResult = new ReturnResult("-5", "系统负载异常");
        }
        //这里为了方便页面查看,写回到页面,正常直接抛出自定义异常就好,由全局异常捕获
        response.setContentType("application/json;charset=utf-8");//防止中文乱码
        response.getWriter().write(JSON.toJSONString(returnResult));//返回页面样式为json格式

    }
}
