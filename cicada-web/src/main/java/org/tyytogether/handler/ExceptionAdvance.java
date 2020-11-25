package org.tyytogether.handler;

import com.google.gson.Gson;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tyytogether.dto.ExceptionDTO;
import org.tyytogether.exception.CicadaException;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.tyytogether.enums.ErrCodeEnum.UNKNOWN_EXCEPTION;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionAdvance {

    private Gson gson = new Gson();

    @ExceptionHandler(CicadaException.class)
    @ResponseBody
    public String CicadaExceptionHandler(CicadaException ex){
        ex.printStackTrace();
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getErrCode(), ex.getNameSpace(), ex.getErrMessage(), getStackTrace(ex));
        return gson.toJson(exceptionDTO);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String allExceptionHandler(Throwable ex){
        ex.printStackTrace();
        ExceptionDTO exceptionDTO = new ExceptionDTO(UNKNOWN_EXCEPTION.getErrCode(), "Unknown", "System exception，See log detail", getStackTrace(ex));
        return gson.toJson(exceptionDTO);
    }

    private String getStackTrace(Throwable ex){
        return Arrays.stream(ex.getStackTrace()).map(it->{
            return it.toString();
        }).collect(Collectors.joining("\n"));
    }

}
