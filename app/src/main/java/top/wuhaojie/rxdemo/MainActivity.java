package top.wuhaojie.rxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wuhaojie.rxdemo.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_retrofit)
    Button mButton;

    @OnClick(R.id.btn_retrofit)
    void toRetrofit() {
        Intent intent = new Intent(this, RetrofitActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
