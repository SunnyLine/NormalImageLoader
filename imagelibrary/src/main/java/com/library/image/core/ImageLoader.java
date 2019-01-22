package com.library.image.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import java.io.File;

/**
 * NormalImageLoader<br>
 * describe ：图片加载
 *
 * @author xugang
 * @date 2019/1/22
 */
public interface ImageLoader {
    void show(Context context, String path, ImageView targetContainer);

    void show(Context context, String path, ImageView targetContainer, FillParameter parameter);

    void show(Context context, Bitmap bitmap, ImageView targetContainer);

    void show(Context context, Bitmap bitmap, ImageView targetContainer, FillParameter parameter);

    void show(Context context, byte[] model, ImageView targetContainer);

    void show(Context context, byte[] model, ImageView targetContainer, FillParameter parameter);

    void show(Context context, Drawable drawable, ImageView targetContainer);

    void show(Context context, Drawable drawable, ImageView targetContainer, FillParameter parameter);

    void show(Context context, File file, ImageView targetContainer);

    void show(Context context, File file, ImageView targetContainer, FillParameter parameter);

    void show(Context context, @RawRes @DrawableRes int resId, ImageView targetContainer);

    void show(Context context, @RawRes @DrawableRes int resId, ImageView targetContainer, FillParameter parameter);

    void show(Context context, Uri uri, ImageView targetContainer);

    void show(Context context, Uri uri, ImageView targetContainer, FillParameter parameter);


}
