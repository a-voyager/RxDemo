package top.wuhaojie.rxdemo.mvp;

import android.content.Context;
import android.content.Intent;

import top.wuhaojie.rxdemo.MainActivity;
import top.wuhaojie.rxdemo.view.AnimActivity;

/**
 * Created by wuhaojie on 2016/5/27 20:02.
 */
public class MainPresenter {
    private MainActivity mActivity;

    public MainPresenter(MainActivity activity) {
        mActivity = activity;
    }

    public void opt() {
        mActivity.showText("此消息在Presenter中发出");
    }

    public void toAnimAct(Context context) {
        Intent intent = new Intent(context, AnimActivity.class);
        context.startActivity(intent);
    }
}
