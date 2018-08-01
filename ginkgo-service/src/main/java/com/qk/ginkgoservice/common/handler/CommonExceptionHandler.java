package com.qk.ginkgoservice.common.handler;


import com.qk.ginkgoservice.common.exception.CommonException;
import com.qk.ginkgoservice.modules.sys.dto.RespDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<RespDTO> handleException(Exception e){
        RespDTO resp = new RespDTO();
        CommonException ex = (CommonException) e;
        resp.code = ex.getCode();
        resp.message = e.getMessage();
        return new ResponseEntity(resp,HttpStatus.OK);
    }
}
