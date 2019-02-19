package com.pullein.image;

import android.app.Application;

import com.library.image.ImageLoader;

/**
 * NormalImageLoader<br>
 * describe ：
 *
 * @author xugang
 * @date 2019/2/18
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.getInstance().init(ImageLoader.TYPE_GLIDE, null);
    }
}
