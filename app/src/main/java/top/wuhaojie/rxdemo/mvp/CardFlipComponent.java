package top.wuhaojie.rxdemo.mvp;

import dagger.Component;
import top.wuhaojie.rxdemo.view.CardFlipActivity;

/**
 * Created by wuhaojie on 2016/5/30 21:33.
 */
@Component(modules = {CardFlipActModule.class})
public interface CardFlipComponent {
    void inject(CardFlipActivity activity);
}
