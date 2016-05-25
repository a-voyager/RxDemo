package top.wuhaojie.rxdemo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wuhaojie on 2016/5/24 22:25.
 */
public interface ApiService {

    @GET("getIpInfo.php")
    Call<IpEntity> getIpInfo(@Query("ip") String ip);

}
