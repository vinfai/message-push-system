package com.cvte.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ControllerAdvice注解的类，需要让spring扫描到。
 * 这个异常处理类要和controller在同一级目录 //?
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 让Spring捕获到所有抛出的Exception异常，并交由这个被注解的方法处理
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(HttpServletRequest request, Exception ex) {

        logger.error(ex.getMessage());
        return ex.getMessage();
    }
}
