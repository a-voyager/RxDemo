package top.wuhaojie.rxdemo.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.rxdemo.R;

public class PaletteActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        ButterKnife.bind(this);

//        Vibrant （有活力） Vibrant dark（有活力 暗色） Vibrant light（有活力 亮色）
//        Muted （柔和） Muted dark（柔和 暗色） Muted light（柔和 亮色）

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        Palette palette = Palette.from(bitmap).generate();

//        mImageView.setBackgroundColor(palette.getVibrantColor(Color.TRANSPARENT));
//        mImageView.setBackgroundColor(palette.getLightVibrantColor(Color.TRANSPARENT));
        mImageView.setBackgroundColor(palette.getMutedColor(Color.TRANSPARENT));

    }
}
