package yizhilu.xiangyao.aopdemo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by xiangyao on 2017/11/18.
 */

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInjet {

    int viewId() default -1;

}
