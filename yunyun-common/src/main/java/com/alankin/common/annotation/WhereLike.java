package com.alankin.common.annotation;

import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * Created by alankin on 2017/2/11.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WhereLike {
    String dbFieldName() default "";
}
