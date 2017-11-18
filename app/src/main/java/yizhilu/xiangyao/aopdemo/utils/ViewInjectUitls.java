package yizhilu.xiangyao.aopdemo.utils;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import yizhilu.xiangyao.aopdemo.annotation.ContetView;
import yizhilu.xiangyao.aopdemo.annotation.ViewInjet;

/**
 * @author xiangyao
 * @date 2017/11/18
 */

public class ViewInjectUitls {

    /**
     * 布局文件注入
     */
    private static final String METHOD_SET_CONTENTVIEW = "setContentView";
    /**
     * findviewbyId
     */
    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    public static void inject(Activity activity) {

        intjectContenView(activity);
        inijectView(activity);
    }

    private static void inijectView(Activity activity) {

        Class<? extends Activity> aClass = activity.getClass();

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            Log.i(aClass.getSimpleName(), "找不到" + field.toString());
            ViewInjet annotation = field.getAnnotation(ViewInjet.class);
            if (annotation != null) {

                int viewId = annotation.viewId();

                if (viewId != -1) {
                    try {
                        Method method = aClass.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);

                        Object invoke = method.invoke(activity, viewId);
                        field.setAccessible(true);
                        field.set(activity, invoke);
                    } catch (Exception e) {
                        Log.i(aClass.getSimpleName(), "找不到" + viewId);
                    }
                }


            }


        }


    }

    /**
     * 注入根布局
     *
     * @param activity
     */
    private static void intjectContenView(Activity activity) {
        /**
         * 通过反射拿到类的实例
         * */
        Class<? extends Activity> aClass = activity.getClass();
        /**
         * 获取当前的的所有注解
         * */
        ContetView annotation = aClass.getAnnotation(ContetView.class);
        if (annotation != null) {
            int contentView = annotation.contenView();
            if (contentView != -1) {
                try {
                    Method method = aClass.getMethod(METHOD_SET_CONTENTVIEW, int.class);

                    method.setAccessible(true);
                    method.invoke(activity, contentView);
                } catch (Exception e) {
                    Log.i(aClass.getSimpleName(), "没找到布局");
                }
            }

        }


    }
}
