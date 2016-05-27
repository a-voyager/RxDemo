package top.wuhaojie.rxdemo.mvp;

import android.content.Context;

import dagger.Component;
import top.wuhaojie.rxdemo.MainActivity;

/**
 * Created by wuhaojie on 2016/5/27 20:10.
 */
@ActivityScrope
@Component(modules = MainModel.class)
public interface MainComponent {

    void inject(MainActivity activity);

//    MainPresenter presenter();

    void inject(Context context);

}
