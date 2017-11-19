package yizhilu.xiangyao.aopdemo.utils;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author xiangyao
 * @date 2017/11/19
 * <p>
 * 动态代理类
 */

public class DynamicHandler implements InvocationHandler {
    /**
     *
     * */
    private WeakReference<Object> handlerRef;
    private final HashMap<String, Method> methodHashMap = new HashMap<>(1);

    public Object getRefHandler() {
        return handlerRef.get();

    }

    public void setHandlerRef(Object handler) {
        this.handlerRef = new WeakReference<Object>(handler);
    }

    public void addMethod(String name, Method method) {
        methodHashMap.put(name, method);
    }

    public DynamicHandler(Object handler) {
        handlerRef = new WeakReference<Object>(handler);
    }

    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {


        String methodName = method.getName();
        method = methodHashMap.get(methodName);
        Object o = handlerRef.get();
        if (o != null) {

            return method.invoke(o, objects);

        }
        return null;
    }
}
