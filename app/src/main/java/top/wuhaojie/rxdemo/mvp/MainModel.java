package top.wuhaojie.rxdemo.mvp;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import top.wuhaojie.rxdemo.MainActivity;

/**
 * Created by wuhaojie on 2016/5/27 20:04.
 */
@Module
public class MainModel {

    private MainActivity mMainActivity;
    private Context mContext;

    public MainModel(MainActivity mainActivity, Context context) {
        mMainActivity = mainActivity;
        mContext = context;
    }

    @ActivityScrope
    @Provides
    MainActivity provideMainActivity() {
        return mMainActivity;
    }


    @ActivityScrope
    @Provides
    MainPresenter provideMainPresenter(MainActivity activity) {
        return new MainPresenter(activity);
    }

    @ActivityScrope
    @Provides
    Context provideContext() {
        return mContext;
    }


    @ActivityScrope
    @Provides
    SharedPreferences provideSp(Context context) {
        return context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

}
