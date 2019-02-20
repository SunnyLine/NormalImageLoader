package com.library.image.core;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;

import com.library.image.core.annotation.DiskCacheStrategy;
import com.library.image.core.annotation.DiskCacheType;

/**
 * NormalImageLoader<br>
 * describe ：全局变量,缓存和占位符
 *
 * @author xugang
 * @date 2019/2/19
 */
public class GlobalConfig {

    private @DiskCacheType
    int diskCacheStrategy;
    /**
     * 跳过内存缓存，为了避免请求网络，即使设置跳过，Glide也会缓存到磁盘
     */
    private boolean skipMemoryCache;

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


    public GlobalConfig(Builder builder) {
        this.diskCacheStrategy = builder.diskCacheStrategy;
        this.skipMemoryCache = builder.skipMemoryCache;
        this.errorDrawable = builder.errorDrawable;
        this.defaultDrawable = builder.defaultDrawable;
        this.blankDrawable = builder.blankDrawable;
        this.errorRes = builder.errorRes;
        this.defaultRes = builder.defaultRes;
        this.blankRes = builder.blankRes;
    }

    public int getDiskCacheStrategy() {
        return diskCacheStrategy;
    }

    public void setDiskCacheStrategy(@DiskCacheType int diskCacheStrategy) {
        this.diskCacheStrategy = diskCacheStrategy;
    }

    public boolean isSkipMemoryCache() {
        return skipMemoryCache;
    }

    public void setSkipMemoryCache(boolean skipMemoryCache) {
        this.skipMemoryCache = skipMemoryCache;
    }

    public Drawable getErrorDrawable() {
        return errorDrawable;
    }

    public void setErrorDrawable(Drawable errorDrawable) {
        this.errorDrawable = errorDrawable;
    }

    public Drawable getDefaultDrawable() {
        return defaultDrawable;
    }

    public void setDefaultDrawable(Drawable defaultDrawable) {
        this.defaultDrawable = defaultDrawable;
    }

    public Drawable getBlankDrawable() {
        return blankDrawable;
    }

    public void setBlankDrawable(Drawable blankDrawable) {
        this.blankDrawable = blankDrawable;
    }

    public int getErrorRes() {
        return errorRes;
    }

    public void setErrorRes(int errorRes) {
        this.errorRes = errorRes;
    }

    public int getDefaultRes() {
        return defaultRes;
    }

    public void setDefaultRes(int defaultRes) {
        this.defaultRes = defaultRes;
    }

    public int getBlankRes() {
        return blankRes;
    }

    public void setBlankRes(int blankRes) {
        this.blankRes = blankRes;
    }

    public static class Builder {
        private @DiskCacheType
        int diskCacheStrategy = DiskCacheStrategy.DISK_CACHE_DEFAULT;
        private boolean skipMemoryCache = false;
        private Drawable errorDrawable = null;
        private @DrawableRes
        int errorRes = -1;
        private Drawable defaultDrawable = null;
        private @DrawableRes
        int defaultRes = -1;
        private Drawable blankDrawable = null;
        private @DrawableRes
        int blankRes = -1;

        public Builder setDiskCacheStrategy(@DiskCacheType int diskCacheStrategy) {
            this.diskCacheStrategy = diskCacheStrategy;
            return this;
        }

        public Builder setSkipMemoryCache(boolean skipMemoryCache) {
            this.skipMemoryCache = skipMemoryCache;
            return this;
        }

        public Builder setErrorResId(@DrawableRes int errorResId) {
            this.errorRes = errorResId;
            return this;
        }

        public Builder setErrorColorId(@ColorInt int colorId) {
            errorDrawable = new ColorDrawable(colorId);
            return this;
        }

        public Builder setDefaultResId(@DrawableRes int defaultResId) {
            this.defaultRes = defaultResId;
            return this;
        }

        public Builder setDefaultColorId(@ColorInt int defaultColorId) {
            defaultDrawable = new ColorDrawable(defaultColorId);
            return this;
        }

        public Builder setBlankResId(@DrawableRes int blankResId) {
            this.blankRes = blankResId;
            return this;
        }

        public Builder setBlankColorId(@ColorInt int blankColorId) {
            blankDrawable = new ColorDrawable(blankColorId);
            return this;
        }

        public GlobalConfig build() {
            return new GlobalConfig(this);
        }
    }
}
