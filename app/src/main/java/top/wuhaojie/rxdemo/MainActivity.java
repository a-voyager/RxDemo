package top.wuhaojie.rxdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wuhaojie.rxdemo.mvp.DaggerMainComponent;
import top.wuhaojie.rxdemo.mvp.MainModel;
import top.wuhaojie.rxdemo.mvp.MainPresenter;
import top.wuhaojie.rxdemo.retrofit.RetrofitActivity;
import top.wuhaojie.rxdemo.view.ImageActivity;
import top.wuhaojie.rxdemo.view.PaletteActivity;
import top.wuhaojie.rxdemo.view.ScrollActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mMainPresenter;

    @Inject
    SharedPreferences sp;

    @BindView(R.id.btn_retrofit)
    Button mButton;

    @OnClick(R.id.btn_retrofit)
    void toRetrofit() {
        Intent intent = new Intent(this, RetrofitActivity.class);
        startActivity(intent);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.btn_notify)
    void sendNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        android.support.v4.app.NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.setSummaryText("更多内容");
        style.setBigContentTitle("点击后的标题");

        // 必须设置SmallIcon才能生效
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("标题")
                .setContentText("正文内容")
                .setColor(Color.WHITE)
                // 需要使用透明图片
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setTicker("状态栏通知")
                .setStyle(style)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .build();
        manager.notify(1, notification);

    }


    @OnClick(R.id.btn_notify_window)
    void sendWindowNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("横幅标题")
                .setContentText("正文")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setFullScreenIntent(pendingIntent, true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        manager.notify(2, notification);
    }


    @OnClick(R.id.btn_to_toolbar)
    void toScrollAct() {
        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_palette)
    void toPaletteAct() {
        Intent intent = new Intent(this, PaletteActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_dagger)
    void optInPresenter() {
        mMainPresenter.opt();
    }

    @OnClick(R.id.btn_to_anim)
    void toAnimAct() {
        mMainPresenter.toAnimAct(this);
    }


    @OnClick(R.id.btn_reg_battery)
    void regBattery() {
        mMainPresenter.regBattery();
    }

    @OnClick(R.id.btn_card_flip)
    void toflipCard() {
        mMainPresenter.toflipCardAnimAct();
    }

    public void showText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_load_img)
    void toImage() {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initDagger();

        if (sp != null)
            Log.d(this.getClass().getSimpleName(), "成功， SP不为空！");

    }

    private void initDagger() {
        DaggerMainComponent.builder().mainModel(new MainModel(this, this)).build().inject(this);
    }

}
