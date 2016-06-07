package top.wuhaojie.rxdemo.mvp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import top.wuhaojie.rxdemo.MainActivity;
import top.wuhaojie.rxdemo.view.AnimActivity;
import top.wuhaojie.rxdemo.view.BlurActivity;
import top.wuhaojie.rxdemo.view.CardFlipActivity;

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

    public void regBattery() {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = mActivity.registerReceiver(null, ifilter);
    }

    public void toflipCardAnimAct() {
        Intent intent = new Intent(mActivity, CardFlipActivity.class);
        mActivity.startActivity(intent);
    }

    public void toBlurAct() {
        Intent intent = new Intent(mActivity, BlurActivity.class);
        mActivity.startActivity(intent);
    }
}
