package com.aiit.utils.exception;

import com.aiit.utils.returns.CommonEnum;
import com.aiit.utils.returns.JsonResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * validate校验 异常统一捕捉处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        //下边ResultCodeEnum.PARAMS_BS_ERROR.getCode()就是你自己自定义的返回code码
        return JsonResult.error(CommonEnum.SIGNAUTION_NOT_MATCH.getResultCode(), message);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public JsonResult BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return JsonResult.error(CommonEnum.SIGNAUTION_NOT_MATCH.getResultCode(), message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JsonResult ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return JsonResult.error(CommonEnum.SIGNAUTION_NOT_MATCH.getResultCode(), message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public JsonResult MethodArgumentTypeMismatchExceptionExecptionHandler(MethodArgumentTypeMismatchException e) {
        String message = e.getPropertyName();
        return JsonResult.error(CommonEnum.BODY_NOT_MATCH.getResultCode(), CommonEnum.BODY_NOT_MATCH.getResultMessage());
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    public JsonResult pageNoFound(NoHandlerFoundException e){
       String message =e.getMessage();
       return JsonResult.error(CommonEnum.NOT_FOUND.getResultCode(),CommonEnum.NOT_FOUND.getResultMessage());
    }
}