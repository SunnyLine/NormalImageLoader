package com.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.library.image.core.FillParameter;
import com.library.image.core.ImageLoader;

import java.io.File;

/**
 * NormalImageLoader<br>
 * describe ：Glide 的实现
 *
 * @author xugang
 * @date 2019/1/22
 */
public class GlideLoader implements ImageLoader {
    @Override
    public void show(Context context, String path, ImageView targetContainer) {
        Glide.with(context).load(path).into(targetContainer);
    }

    @Override
    public void show(Context context, String path, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, Bitmap bitmap, ImageView targetContainer) {
        Glide.with(context).load(bitmap).into(targetContainer);
    }

    @Override
    public void show(Context context, Bitmap bitmap, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, byte[] model, ImageView targetContainer) {
        Glide.with(context).load(model).into(targetContainer);
    }

    @Override
    public void show(Context context, byte[] model, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, Drawable drawable, ImageView targetContainer) {
        Glide.with(context).load(drawable).into(targetContainer);
    }

    @Override
    public void show(Context context, Drawable drawable, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, File file, ImageView targetContainer) {
        Glide.with(context).load(file).into(targetContainer);
    }

    @Override
    public void show(Context context, File file, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, int resId, ImageView targetContainer) {
        Glide.with(context).load(resId).into(targetContainer);
    }

    @Override
    public void show(Context context, int resId, ImageView targetContainer, FillParameter parameter) {

    }

    @Override
    public void show(Context context, Uri uri, ImageView targetContainer) {
        Glide.with(context).load(uri).into(targetContainer);
    }

    @Override
    public void show(Context context, Uri uri, ImageView targetContainer, FillParameter parameter) {

    }
}
