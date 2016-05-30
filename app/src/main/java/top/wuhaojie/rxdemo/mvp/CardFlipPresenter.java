package top.wuhaojie.rxdemo.mvp;

import android.content.Context;

import top.wuhaojie.rxdemo.view.BaseView;
import top.wuhaojie.rxdemo.view.CardFlipActivity;

/**
 * Created by wuhaojie on 2016/5/30 21:34.
 */
public class CardFlipPresenter {

    private Context mContext;

    private BaseView mBaseView;
    private final CardFlipActivity mActivity;


    public CardFlipPresenter(Context context, BaseView baseView) {
        mContext = context;
        mBaseView = baseView;
        mActivity = (CardFlipActivity) mBaseView;
    }

    public void changeCard() {
        mActivity.changeCardView();
    }
}
