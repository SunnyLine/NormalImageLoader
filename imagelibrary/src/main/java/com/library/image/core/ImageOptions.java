package com.library.image.core;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import java.io.File;

/**
 * NormalImageLoader<br>
 * describe ：填充参数信息,可以设置旋转，尺寸，缩放，裁剪，缓存，异步/同步等
 *
 * @author xugang
 * @date 2019/1/22
 */
public class ImageOptions {
    /**
     * 加载容器
     */
    private ImageView targetContainer;
    /*****以下加载图片资源*****/
    private String path;
    private Bitmap bitmap;
    private Drawable drawable;
    private File file;
    private @RawRes
    @DrawableRes
    int resId;
    private Uri uri;
    /*****以上加载图片资源*****/
    private ImageSize imageSize;

    /**
     * 跳过内存缓存，为了避免请求网络，即使设置跳过，Glide也会缓存到磁盘
     */
    private boolean isSkipMemoryCache;
    /**
     * 加载错误显示图片
     */
    private Drawable errorDrawable;
    private @DrawableRes
    int errorRes;
    /**
     * 加载成功前显示图片
     */
    private Drawable defaultDrawable;
    private @DrawableRes
    int defaultRes;
    /**
     * 加载URL为空显示图片
     */
    private Drawable blankDrawable;
    private @DrawableRes
    int blankRes;

    private boolean isGif;

    private OnProgressListener onProgressListener;

    public ImageOptions(Builder builder) {
        this.errorDrawable = builder.errorDrawable;
        this.blankDrawable = builder.blankDrawable;
        this.defaultDrawable = builder.defaultDrawable;
        this.errorRes = builder.errorRes;
        this.defaultRes = builder.defaultRes;
        this.blankRes = builder.blankRes;
        this.targetContainer = builder.targetContainer;
        this.path = builder.path;
        this.bitmap = builder.bitmap;
        this.drawable = builder.drawable;
        this.file = builder.file;
        this.resId = builder.resId;
        this.uri = builder.uri;
        this.imageSize = builder.imageSize;
        this.isGif = builder.isGif;
        this.isSkipMemoryCache = builder.isSkipMemoryCache;
        this.onProgressListener = builder.onProgressListener;
    }

    public OnProgressListener getOnProgressListener() {
        return onProgressListener;
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    public Drawable getErrorDrawable() {
        return errorDrawable;
    }

    public void setErrorDrawable(Drawable errorDrawable) {
        this.errorDrawable = errorDrawable;
    }

    public int getErrorRes() {
        return errorRes;
    }

    public void setErrorRes(int errorRes) {
        this.errorRes = errorRes;
    }

    public Drawable getDefaultDrawable() {
        return defaultDrawable;
    }

    public void setDefaultDrawable(Drawable defaultDrawable) {
        this.defaultDrawable = defaultDrawable;
    }

    public int getDefaultRes() {
        return defaultRes;
    }

    public void setDefaultRes(int defaultRes) {
        this.defaultRes = defaultRes;
    }

    public Drawable getBlankDrawable() {
        return blankDrawable;
    }

    public void setBlankDrawable(Drawable blankDrawable) {
        this.blankDrawable = blankDrawable;
    }

    public int getBlankRes() {
        return blankRes;
    }

    public void setBlankRes(int blankRes) {
        this.blankRes = blankRes;
    }

    public boolean isSkipMemoryCache() {
        return isSkipMemoryCache;
    }

    public void setSkipMemoryCache(boolean skipMemoryCache) {
        this.isSkipMemoryCache = skipMemoryCache;
    }

    public ImageView getTargetContainer() {
        return targetContainer;
    }

    public boolean isGif() {
        return isGif;
    }

    public void setGif(boolean gif) {
        isGif = gif;
    }

    public void setTargetContainer(ImageView targetContainer) {
        this.targetContainer = targetContainer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(@RawRes
                         @DrawableRes int resId) {
        this.resId = resId;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public final static class Builder {
        private Drawable errorDrawable = null;
        private @DrawableRes
        int errorRes = -1;
        private Drawable defaultDrawable = null;
        private @DrawableRes
        int defaultRes = -1;
        private Drawable blankDrawable = null;
        private @DrawableRes
        int blankRes = -1;
        private ImageView targetContainer;
        private String path = null;
        private Bitmap bitmap = null;
        private Drawable drawable = null;
        private File file = null;
        private int resId = -1;
        private Uri uri = null;
        private ImageSize imageSize = null;
        /**
         * 跳过内存缓存，为了避免请求网络，即使设置跳过，Glide也会缓存到磁盘
         */
        private boolean isSkipMemoryCache = false;
        private boolean isGif = false;
        /**
         * 下载进度回调
         */
        private OnProgressListener onProgressListener;

        public Builder(ImageView targetContainer, Uri uri) {
            this.targetContainer = targetContainer;
            this.uri = uri;
        }

        public Builder(ImageView targetContainer, String path) {
            this.targetContainer = targetContainer;
            this.path = path;
        }

        public Builder(ImageView targetContainer, Bitmap bitmap) {
            this.targetContainer = targetContainer;
            this.bitmap = bitmap;
        }

        public Builder(ImageView targetContainer, Drawable drawable) {
            this.targetContainer = targetContainer;
            this.drawable = drawable;
        }

        public Builder(ImageView targetContainer, File file) {
            this.targetContainer = targetContainer;
            this.file = file;
        }

        public Builder(ImageView targetContainer, @RawRes
        @DrawableRes int resId) {
            this.targetContainer = targetContainer;
            this.resId = resId;
        }

        public Builder setOnProgressListener(OnProgressListener onProgressListener) {
            this.onProgressListener = onProgressListener;
            return this;
        }

        public Builder setSkipMemoryCache(boolean skipMemoryCache) {
            this.isSkipMemoryCache = skipMemoryCache;
            return this;
        }

        public Builder setGif(boolean gif) {
            isGif = gif;
            return this;
        }

        public Builder setImageSize(int width, int height) {
            this.imageSize = new ImageSize(width, height);
            return this;
        }

        public Builder setErrorResId(@DrawableRes int errorResId) {
            this.errorRes = errorResId;
            return this;
        }

        public Builder setErrorColorId(@ColorInt int colorId) {
            this.errorDrawable = new ColorDrawable(colorId);
            return this;
        }

        public Builder setDefaultResId(@DrawableRes int defaultResId) {
            this.defaultRes = defaultResId;
            return this;
        }

        public Builder setDefaultColorId(@ColorInt int defaultColorId) {
            this.defaultDrawable = new ColorDrawable(defaultColorId);
            return this;
        }

        public Builder setBlankResId(@DrawableRes int blankResId) {
            this.blankRes = blankResId;
            return this;
        }

        public Builder setBlankColorId(@ColorInt int blankColorId) {
            this.blankDrawable = new ColorDrawable(blankColorId);
            return this;
        }

        public ImageOptions build() {
            return new ImageOptions(this);
        }
    }
}
