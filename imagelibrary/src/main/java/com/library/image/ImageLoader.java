package com.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import com.library.image.core.GlobalConfig;
import com.library.image.core.IImageLoaderStrategy;
import com.library.image.core.ImageOptions;
import com.library.image.core.OnProgressListener;
import com.library.image.core.annotation.ImageLibrary;
import com.library.image.core.annotation.LibraryType;
import com.library.image.core.glide.GlideLoader;

import java.io.File;

/**
 * NormalImageLoader<br>
 * describe ：图片加载的壳,必备权限：网络、SD存储
 *
 * @author xugang
 * @date 2019/1/22
 */
public class ImageLoader {
    private final static ImageLoader imageManger = new ImageLoader();
    IImageLoaderStrategy loader;

    private ImageLoader() {
    }

    public final static ImageLoader getInstance() {
        return imageManger;
    }

    public void init(@LibraryType int type) {
        init(type, null);
    }

    public void init(@LibraryType int type, GlobalConfig config) {
        if (loader != null) {
            throw new RuntimeException("ImageLoader have been initialized !!!");
        }
        switch (type) {
            case ImageLibrary.TYPE_GLIDE:
                loader = GlideLoader.getInstance();
                break;
            default:
                loader = GlideLoader.getInstance();
                break;
        }
        loader.configGlobalVariable(config);
    }

    public void show(String path, ImageView targetContainer) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, path).build());
        }
    }

    public void show(String path, ImageView targetContainer, OnProgressListener listener) {
        if (loader != null) {
            loader.showImage(new ImageOptions.Builder(targetContainer, path).setOnProgressListener(listener).build());
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
