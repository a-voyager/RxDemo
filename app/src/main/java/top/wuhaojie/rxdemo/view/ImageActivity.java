package top.wuhaojie.rxdemo.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.DraweeView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import top.wuhaojie.rxdemo.R;

public class ImageActivity extends AppCompatActivity {

    private DraweeView mDvImage;

    @OnClick(R.id.btn_load_img)
    void loadImg() {
        Uri uri = Uri.parse("http://7xqdz8.com1.z0.glb.clouddn.com/blog_logo.jpg");
        mDvImage.setImageURI(uri);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        mDvImage = (DraweeView) findViewById(R.id.dv_image);
    }
}
