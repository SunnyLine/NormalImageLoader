package com.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import com.library.image.core.GlideLoader;
import com.library.image.core.IImageLoaderStrategy;
import com.library.image.core.ImageOptions;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * NormalImageLoader<br>
 * describe ：图片加载的壳,必备权限：网络、SD存储
 *
 * @author xugang
 * @date 2019/1/22
 */
public class ImageLoader {
    private final static ImageLoader imageManger = new ImageLoader();

    /**
     * Glide 加载图片
     */
    public final static int TYPE_GLIDE = 0x001;

    IImageLoaderStrategy loader;

    private ImageLoader() {
    }

    public final static ImageLoader getInstance() {
        return imageManger;
    }

    @IntDef({TYPE_GLIDE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }


    public void init(@Type int type) {
        switch (type) {
            case ImageLoader.TYPE_GLIDE:
                loader = new GlideLoader();
                break;
            default:
                loader = new GlideLoader();
                break;
        }
    }

    public void show(String path, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, path).build());
        }
    }

    public void show(Uri uri, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, uri).build());
        }
    }

    public void show(Bitmap bitmap, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, bitmap).build());
        }
    }

    public void show(Drawable drawable, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, drawable).build());
        }
    }

    public void show(File file, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, file).build());
        }
    }

    public void show(@RawRes
                     @DrawableRes int resId, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, resId).build());
        }
    }

    public void show(ImageOptions options) {
        if (loader != null) {
            loader.showImage(options);
        }
    }

    public void clearMemory(Context context) {
        if (loader != null) {
            loader.clearMemory(context);
        }
    }

    public void clearDiskCache(Context context) {
        if (loader != null) {
            loader.clearDiskCache(context);
        }
    }

}
