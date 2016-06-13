package top.wuhaojie.rxdemo.entities.blur;

import top.wuhaojie.rxdemo.entities.base.Item;

/**
 * Created by wuhaojie on 2016/6/13 21:13.
 */
public class ImageItem implements Item {
    private int res;

    public ImageItem(int res) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
