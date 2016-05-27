package top.wuhaojie.rxdemo.mvp;

import top.wuhaojie.rxdemo.MainActivity;

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
}
