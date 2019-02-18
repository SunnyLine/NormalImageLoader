package com.library.image.core;

import android.content.Context;

/**
 * NormalImageLoader<br>
 * describe ：图片加载
 *
 * @author xugang
 * @date 2019/1/22
 */
public interface IImageLoaderStrategy {
    void showImage(ImageOptions options);

    void clearMemory(Context context);

    void clearDiskCache(Context context);

}
