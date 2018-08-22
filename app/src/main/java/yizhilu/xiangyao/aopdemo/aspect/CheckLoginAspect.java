package yizhilu.xiangyao.aopdemo.aspect;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

import yizhilu.xiangyao.aopdemo.annotation.CheckLogin;

/**
 * Created by xiangyao on 2017/11/10.
 */
@Aspect
public class CheckLoginAspect {


    /**
     * Advice（通知）: 注入到class文件中的代码。典型的 Advice 类型有 before、after 和 around，
     * 分别表示在目标方法执行之前、执行后和完全替代目标方法执行的代码。 除了在方法中注入代码，
     * 也可能会对代码做其他修改，比如在一个class中增加字段或者接口。
     */
    @Around("execution(!synthetic * *(..)) && onLogMethod()")
    public Object haha(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return logMethod(proceedingJoinPoint);
    }

    private Object logMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = null;

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        // 通过Method对象得到切点上的注解
        CheckLogin annotation = method.getAnnotation(CheckLogin.class);
        int userId = annotation.userId();

        if (userId == 0) {
            Toast.makeText((Context) proceedingJoinPoint.getTarget(),"mother fuck 困扰了我 好久,终于偶然间看到解决办法了",1).show();
        } else {
            result = proceedingJoinPoint.proceed();
        }
        return result;

    }


    /**
     * 切入点
     * ps 所有LogUtils注解的地方
     * 可以定定义多个
     */
    @Pointcut("@within(yizhilu.xiangyao.aopdemo.annotation.CheckLogin)||@annotation(yizhilu.xiangyao.aopdemo.annotation.CheckLogin)")
    public void onLogMethod() {
    }
}
