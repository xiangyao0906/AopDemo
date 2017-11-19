package yizhilu.xiangyao.aopdemo.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiangyao on 2017/11/19.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ClickEvent(listenerType = View.OnClickListener.class, listenerSetter = "setOnClickListener", methodName = "onClick")
public @interface OnClick {
    int[] value();
}
