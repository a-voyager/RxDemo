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
import android.view.animation.Animation;
import android.view.animation.Transformation;

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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.btn_change_size)
    void changeSize() {
//        TransitionValues start = new TransitionValues();
//        start.values.put("android:scale:scaleX", "0");
//        start.view = mCardView;
//        TransitionValues stop = new TransitionValues();
//        stop.values.put("android:scale:scaleX", "100");
//        stop.view = mCardView;
//        ChangeBounds changeBounds = new ChangeBounds();
//        Animator animator = changeBounds.createAnimator((ViewGroup) this.getWindow().getDecorView(), start, stop);
//        animator.start();

//        ScaleAnimation scale = new ScaleAnimation((float)1.0, (float)1.0, (float)1.0, (float)2.0);
//        scale.setFillAfter(true);
//        scale.setDuration(500);
//        mCardView.startAnimation(scale);

        ResizeAnimation resizeAnimation = new ResizeAnimation(mCardView, (int) (mCardView.getWidth() * 1.0), (int) (mCardView.getHeight() * 1.5));
        resizeAnimation.setDuration(1000);
        mCardView.startAnimation(resizeAnimation);

    }

    public static class ResizeAnimation extends Animation {
        final int startWidth;
        final int targetWidth;
        final int targetHeight;
        final int startHeight;
        View view;

        public ResizeAnimation(View view, int targetWidth, int targetHeight) {
            this.view = view;
            this.targetWidth = targetWidth;
            this.targetHeight = targetHeight;
            startWidth = view.getWidth();
            startHeight = view.getHeight();
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            int newWidth = (int) (startWidth + (targetWidth - startWidth) * interpolatedTime);
            int newHeight = (int) (startHeight + (targetHeight - startHeight) * interpolatedTime);
            view.getLayoutParams().width = newWidth;
            view.getLayoutParams().height = newHeight;
            view.requestLayout();
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
    }
}
