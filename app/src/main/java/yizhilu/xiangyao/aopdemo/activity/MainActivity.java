package yizhilu.xiangyao.aopdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yizhilu.xiangyao.aopdemo.R;
import yizhilu.xiangyao.aopdemo.annotation.CheckLogin;
import yizhilu.xiangyao.aopdemo.annotation.ContetView;
import yizhilu.xiangyao.aopdemo.annotation.LogUtils;
import yizhilu.xiangyao.aopdemo.annotation.OnClick;
import yizhilu.xiangyao.aopdemo.annotation.ViewInjet;
import yizhilu.xiangyao.aopdemo.utils.ViewInject;


/**
 * http://blog.csdn.net/crazy__chen/article/details/52014672
 *
 * @author xiangyao
 */

@ContetView(contenView = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInjet(viewId = R.id.textview)
    TextView textView;
    @ViewInjet(viewId = R.id.button)
    Button button;
    int userId = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInject.inject(this);
//        haha("当你看到这句话userId 是不为0的");


    }

    @LogUtils
    @CheckLogin(userId = 0)
    public void haha(String xiangyao) {
        textView.setText(xiangyao);
    }

    /**
     * 思考题部分
     */

    @OnClick(R.id.button)
    public void clickBtnInvoked(View view) {

//        textView.setText(button.getText());
//        Log.i("xiangyao", "333333333333333333333333");
    }

    @OnClick(R.id.button)
    public void onClickc(View view) {
        haha("");
        Log.i("xiangyao", "222222222222222222222");
    }
}
