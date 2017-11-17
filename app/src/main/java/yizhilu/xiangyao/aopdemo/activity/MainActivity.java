package yizhilu.xiangyao.aopdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import yizhilu.xiangyao.aopdemo.R;
import yizhilu.xiangyao.aopdemo.annotation.CheckLogin;
import yizhilu.xiangyao.aopdemo.annotation.LogUtils;


/**
 * http://blog.csdn.net/crazy__chen/article/details/52014672
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        haha("当你看到这句话userId 是不为0的");

    }

    @CheckLogin(userId =0)
    private void haha(String xiangyao) {

        Log.i("xiangyao",xiangyao);

    }
}
