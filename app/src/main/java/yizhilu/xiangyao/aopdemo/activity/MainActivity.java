package yizhilu.xiangyao.aopdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import yizhilu.xiangyao.aopdemo.R;
import yizhilu.xiangyao.aopdemo.annotation.CheckLogin;
import yizhilu.xiangyao.aopdemo.annotation.ContetView;
import yizhilu.xiangyao.aopdemo.annotation.LogUtils;
import yizhilu.xiangyao.aopdemo.annotation.ViewInjet;
import yizhilu.xiangyao.aopdemo.utils.ViewInjectUitls;


/**
 * http://blog.csdn.net/crazy__chen/article/details/52014672
 *
 * @author xiangyao
 */

@ContetView(contenView = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInjet(viewId = R.id.textview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInjectUitls.inject(this);

        haha("当你看到这句话userId 是不为0的");

    }

    @LogUtils
    @CheckLogin(userId = 10)
    public void haha(String xiangyao) {

        textView.setText(xiangyao);
    }
}
