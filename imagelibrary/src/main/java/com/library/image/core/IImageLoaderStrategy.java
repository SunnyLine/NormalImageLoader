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

    /**
     * 配置全局变量，缓存和占位符等
     *
     * @param config 全局配置信息
     */
    void configGlobalVariable(GlobalConfig config);

    /**
     * 展示图片
     *
     * @param options 配置信息
     */
    void showImage(ImageOptions options);

    /**
     * 清除内存缓存
     */
    void clearMemory(Context context);

    void clearDiskCache(Context context);

}
