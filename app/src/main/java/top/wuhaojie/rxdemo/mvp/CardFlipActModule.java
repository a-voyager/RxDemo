package top.wuhaojie.rxdemo.mvp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import top.wuhaojie.rxdemo.view.BaseView;

/**
 * Created by wuhaojie on 2016/5/30 21:32.
 */
@Module
public class CardFlipActModule {

    private Context mContext;

    private BaseView mBaseView;

    public CardFlipActModule(Context context, BaseView baseView) {
        mContext = context;
        mBaseView = baseView;
    }

//    @Provides
//    Context provideContext() {
//        return mContext;
//    }
//
//    @Provides
//    BaseView provideBaseView() {
//        return mBaseView;
//    }

    @Provides
    CardFlipPresenter providePresenter() {
        return new CardFlipPresenter(mContext, mBaseView);
    }

}
