package top.wuhaojie.rxdemo.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wuhaojie.rxdemo.R;
import top.wuhaojie.rxdemo.mvp.CardFlipActModule;
import top.wuhaojie.rxdemo.mvp.CardFlipPresenter;
import top.wuhaojie.rxdemo.mvp.DaggerCardFlipComponent;

public class CardFlipActivity extends AppCompatActivity implements BaseView {


    private boolean mBackIsShow;

    @OnClick(R.id.btn_card_flip)
    void onClickChangeCard() {
        mPresenter.changeCard();
    }


    @Inject
    CardFlipPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        ButterKnife.bind(this);

        initDagger();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.fl_container, new CardAFragment()).commit();
        }

    }

    private void initDagger() {
        DaggerCardFlipComponent.builder().cardFlipActModule(new CardFlipActModule(this, this)).build().inject(this);
    }

    public void changeCardView() {
        if (mBackIsShow) {
            getFragmentManager().popBackStack();
        }

        mBackIsShow = true;

        // 设置动画要在变换之前设置

        getFragmentManager().beginTransaction().setCustomAnimations(
                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                R.animator.card_flip_left_in, R.animator.card_flip_left_out).replace(R.id.fl_container, new CardBFragment()).addToBackStack(null).commit();


    }

    public static class CardAFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.card_front, container, false);
        }
    }

    public static class CardBFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.card_behind, container, false);
        }
    }

}
