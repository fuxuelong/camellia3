package com.qk.userservice.utils;


import com.qk.commonservice.dto.RespDTO;
import com.qk.commonservice.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangyu
 * @data 2018/7/14
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<RespDTO> handleException(Exception e){
        RespDTO resp = new RespDTO();
        CommonException ex = (CommonException) e;
        resp.code = ex.getCode();
        resp.error = e.getMessage();
        return new ResponseEntity(resp,HttpStatus.OK);
    }
}
