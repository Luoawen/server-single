package com.alankin.gateway.web.base;

import com.alankin.common.base.BaseController;
import com.alankin.gateway.web.exception.UserInvalidException;
import com.alankin.gateway.web.vo.response.Result;
import com.alankin.gateway.web.vo.response.ResultConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * Created by alankin on 2018/12/31.
 */
public class BaseWebController extends BaseController {
    @ExceptionHandler(UserInvalidException.class)
    @ResponseBody
    public Result handleIllegalParamException(UserInvalidException e) {
        return new Result(ResultConstant.EXCEPTION_NO_USER);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        if (errors.size() > 0) {
            return new Result(ResultConstant.EXCEPTION_FIELD_INVALID, errors.get(0).getDefaultMessage());
        }
        return new Result(ResultConstant.EXCEPTION_FIELD_INVALID);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result handleIllegalParamException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            return new Result(ResultConstant.EXCEPTION_FIELD_INVALID, item.getMessage());
        }
        return new Result(ResultConstant.EXCEPTION_FIELD_INVALID);
    }
}
