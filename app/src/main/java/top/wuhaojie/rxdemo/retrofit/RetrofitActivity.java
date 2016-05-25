package top.wuhaojie.rxdemo.retrofit;

import android.os.Bundle;
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
import retrofit2.converter.gson.GsonConverterFactory;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
