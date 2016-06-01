package top.wuhaojie.rxdemo.retrofit;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import top.wuhaojie.rxdemo.R;

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.tv_response)
    TextView mTextView;

    @OnClick(R.id.btn_visit)
    void visitInternet(View v) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ip.taobao.com/service/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<IpEntity> ipInfo = apiService.getIpInfo("114.215.144.204");
        ipInfo.enqueue(new Callback<IpEntity>() {
            @Override
            public void onResponse(Call<IpEntity> call, Response<IpEntity> response) {
                IpEntity ipEntity = response.body();
                mTextView.setText(ipEntity.toString());
            }

            @Override
            public void onFailure(Call<IpEntity> call, Throwable t) {

            }
        });
    }


    @OnClick(R.id.btn_visit_use_rx)
    void visitInternetUseRx() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ip.taobao.com/service/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<IpEntity> ipInfoUseRx = apiService.getIpInfoUseRx("114.215.144.204");

        ipInfoUseRx.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IpEntity>() {
                    @Override
                    public void onCompleted() {
                        Snackbar.make(RetrofitActivity.this.getWindow().getDecorView(), "完成数据读取", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(RetrofitActivity.this.getWindow().getDecorView(), "访问失败", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(IpEntity ipEntity) {
                        mTextView.setText(ipEntity.toString());
                    }
                });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
