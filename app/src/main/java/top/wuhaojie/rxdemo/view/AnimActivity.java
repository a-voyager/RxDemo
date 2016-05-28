package top.wuhaojie.rxdemo.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wuhaojie.rxdemo.R;

public class AnimActivity extends AppCompatActivity {

    @BindView(R.id.card_iv)
    CardView mCardView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.btn_show)
    void show() {
//        int cx = (mCardView.getLeft() + mCardView.getRight()) / 2;
//        int cy = (mCardView.getTop() + mCardView.getBottom()) / 2;

        int cx = mCardView.getWidth();
        int cy = mCardView.getHeight();

        int radius = Math.max(mCardView.getWidth(), mCardView.getHeight());

        Animator animator = ViewAnimationUtils.createCircularReveal(mCardView, cx, cy, 0, radius);

        mCardView.setVisibility(View.VISIBLE);

        animator.start();

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.btn_disappear)
    void disappear() {
        int cx = mCardView.getWidth();
        int cy = mCardView.getHeight();

        int radius = Math.max(mCardView.getWidth(), mCardView.getHeight());

        Animator animator = ViewAnimationUtils.createCircularReveal(mCardView, cx, cy, radius, 0);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mCardView.setVisibility(View.INVISIBLE);
            }
        });

        animator.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
    }
}
