package yizhilu.xiangyao.aopdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiangyao on 2017/11/18.
 */


/**
 * @Target 注解生命的位置 可以是类 方法 构造 或者方法的参数
 * @Retention 注解的生命周期  可以是编译时期。。
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContetView {

    int contenView() default -1;
}
