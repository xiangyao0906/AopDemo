package yizhilu.xiangyao.aopdemo.Aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * Created by xiangyao on 2017/11/10.
 */
@Aspect
public class LogAspect {


    /**
     * Advice（通知）: 注入到class文件中的代码。典型的 Advice 类型有 before、after 和 around，
     * 分别表示在目标方法执行之前、执行后和完全替代目标方法执行的代码。 除了在方法中注入代码，
     * 也可能会对代码做其他修改，比如在一个class中增加字段或者接口。
     * */
    @Around("onLogMethod()")
    public Object haha(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return logMethod(proceedingJoinPoint);
    }

    private Object logMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.i("xiangyao", proceedingJoinPoint.getSignature().toShortString() + " Args : " + (proceedingJoinPoint.getArgs() != null ? Arrays.deepToString(proceedingJoinPoint.getArgs()) : ""));
        Object result = proceedingJoinPoint.proceed();
        String type = ((MethodSignature) proceedingJoinPoint.getSignature()).getReturnType().toString();
        Log.i("xiangyao", proceedingJoinPoint.getSignature().toShortString() + " Result : " + ("void".equalsIgnoreCase(type) ? "void" : result));
        return result;
    }


    /**
     * 切入点
     *      ps 所有LogUtils注解的地方
     *              可以定定义多个
     * */
    @Pointcut("@within(yizhilu.xiangyao.aopdemo.annotation.LogUtils)||@annotation(yizhilu.xiangyao.aopdemo.annotation.LogUtils)")
    public void onLogMethod() {
    }
}
