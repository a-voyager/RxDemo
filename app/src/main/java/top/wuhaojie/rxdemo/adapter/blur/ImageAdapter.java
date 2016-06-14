package top.wuhaojie.rxdemo.adapter.blur;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import top.wuhaojie.rxdemo.R;
import top.wuhaojie.rxdemo.entities.blur.ImageItem;

/**
 * Created by wuhaojie on 2016/6/13 21:10.
 */
public class ImageAdapter extends RecyclerView.Adapter {

    private List<ImageItem> mList = new ArrayList<>();

    {
        mList.add(new ImageItem(R.drawable.img_1));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_3));
        mList.add(new ImageItem(R.drawable.img_4));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_1));
        mList.add(new ImageItem(R.drawable.img_3));
        mList.add(new ImageItem(R.drawable.img_1));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_4));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_3));
        mList.add(new ImageItem(R.drawable.img_4));
        mList.add(new ImageItem(R.drawable.img_1));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_3));
        mList.add(new ImageItem(R.drawable.img_2));
        mList.add(new ImageItem(R.drawable.img_4));
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.mImageView.setImageResource(mList.get(position).getRes());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        final ImageView mImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(getClass().getSimpleName(), "当前点击位置: " + getAdapterPosition());
                    Snackbar.make(v, "当前点击位置: " + getAdapterPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
