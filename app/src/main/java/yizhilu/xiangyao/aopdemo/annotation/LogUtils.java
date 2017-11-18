package yizhilu.xiangyao.aopdemo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiangyao on 2017/11/10.
 */

@Target({METHOD})
@Retention(RUNTIME)
public @interface LogUtils {
}
