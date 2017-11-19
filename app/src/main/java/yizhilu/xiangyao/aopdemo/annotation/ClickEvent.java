package yizhilu.xiangyao.aopdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiangyao on 2017/11/19.
 */


@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface ClickEvent {
    Class<?> listenerType();

    String listenerSetter();

    String methodName();
}
