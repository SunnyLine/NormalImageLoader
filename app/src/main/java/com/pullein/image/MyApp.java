package com.pullein.image;

import android.app.Application;

import com.library.image.ImageLoader;
import com.library.image.core.GlobalConfig;
import com.library.image.core.annotation.DiskCacheStrategy;
import com.library.image.core.annotation.ImageLibrary;

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
        ImageLoader.getInstance().init(ImageLibrary.TYPE_GLIDE, new GlobalConfig.Builder().setDiskCacheStrategy(DiskCacheStrategy.DISK_CACHE_NONE).setSkipMemoryCache(true).build());
    }
}
