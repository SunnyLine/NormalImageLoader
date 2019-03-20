package com.library.image.core.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.library.image.core.GlobalConfig;
import com.library.image.core.IImageLoaderStrategy;
import com.library.image.core.ImageOptions;
import com.library.image.core.OnProgressListener;
import com.library.image.core.Shape;
import com.library.image.core.annotation.DiskCacheStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * NormalImageLoader<br>
 * describe ：Glide 简单实现
 *
 * @author xugang
 * @date 2019/2/18
 */
public class GlideLoader implements IImageLoaderStrategy {

    private GlobalConfig mGlobalConfig;
    private static GlideLoader loader = new GlideLoader();
    private Map<String, OnProgressListener> mProgressListeners = new HashMap<>();

    private GlideLoader() {
    }

    public static GlideLoader getInstance() {
        return loader;
    }

    public OnProgressListener getProgressListener(String url) {
        return mProgressListeners.get(url);
    }

    public void removeProgressListener(String url) {
        if (!TextUtils.isEmpty(url)) {
            mProgressListeners.remove(url);
        }
    }

    @Override
    public void configGlobalVariable(@Nullable GlobalConfig config) {
        if (config == null) {
            mGlobalConfig = new GlobalConfig.Builder()
                    .setDiskCacheStrategy(DiskCacheStrategy.DISK_CACHE_DEFAULT)
                    .setSkipMemoryCache(false)
                    .build();
            return;
        }
        mGlobalConfig = config;
    }

    @Override
    public void showImage(ImageOptions options) {
        parserOptions(options);
    }

    @Override
    public void clearMemory(Context context) {
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearDiskCache(Context context) {
        //TODO 未做线程维护，后期再做
        Thread thread = new Thread(new ClearDiskCache(context));
        thread.start();
    }


    private void parserOptions(ImageOptions options) {
        RequestManager manager = Glide.with(options.getTargetContainer().getContext());
        if (options.isGif()) {
            manager.asGif();
        } else {
            manager.asDrawable();
        }
        if (!TextUtils.isEmpty(options.getPath()) && options.getOnProgressListener() != null) {
            mProgressListeners.put(options.getPath(), options.getOnProgressListener());
        }
        RequestBuilder<Drawable> requestBuilder = null;
        if (options.getBitmap() != null) {
            requestBuilder = manager.load(options.getBitmap());
        } else if (options.getResId() != -1) {
            requestBuilder = manager.load(options.getResId());
        } else if (options.getDrawable() != null) {
            requestBuilder = manager.load(options.getDrawable());
        } else if (options.getFile() != null) {
            requestBuilder = manager.load(options.getFile());
        } else if (options.getPath() != null) {
            requestBuilder = manager.load(options.getPath());
        } else if (options.getUri() != null) {
            requestBuilder = manager.load(options.getUri());
        }
        RequestOptions requestOptions = new RequestOptions();
        //设置占位符
        Drawable blankDrawable = options.getBlankDrawable() != null ? options.getBlankDrawable() : mGlobalConfig.getBlankDrawable();
        int blankRes = options.getBlankRes() != -1 ? options.getBlankRes() : mGlobalConfig.getBlankRes();
        Drawable errorDrawable = options.getErrorDrawable() != null ? options.getErrorDrawable() : mGlobalConfig.getErrorDrawable();
        int errorRes = options.getErrorRes() != -1 ? options.getErrorRes() : mGlobalConfig.getErrorRes();
        Drawable defaultDrawable = options.getDefaultDrawable() != null ? options.getDefaultDrawable() : mGlobalConfig.getDefaultDrawable();
        int defaultRes = options.getDefaultRes() != -1 ? options.getDefaultRes() : mGlobalConfig.getDefaultRes();
        if (blankRes != -1) {
            requestOptions.fallback(blankRes);
        } else if (blankDrawable != null) {
            requestOptions.fallback(blankDrawable);
        }
        if (defaultRes != -1) {
            requestOptions.placeholder(defaultRes);
        } else if (defaultDrawable != null) {
            requestOptions.placeholder(defaultDrawable);
        }
        if (errorRes != -1) {
            requestOptions.error(errorRes);
        } else if (errorDrawable != null) {
            requestOptions.error(errorDrawable);
        }
        //设置填充图片大小，单位像素
        if (options.getImageSize() != null) {
            requestOptions.override(options.getImageSize().getWidth(), options.getImageSize().getHeight());
        }
        //设置磁盘缓存策略
        switch (mGlobalConfig.getDiskCacheStrategy()) {
            case DiskCacheStrategy.DISK_CACHE_ALL:
                requestOptions.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL);
                break;
            case DiskCacheStrategy.DISK_CACHE_NONE:
                requestOptions.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE);
                break;
            case DiskCacheStrategy.DISK_CACHE_SOURCE:
                requestOptions.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.DATA);
                break;
            case DiskCacheStrategy.DISK_CACHE_RESULT:
                requestOptions.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE);
                break;
            default:
                requestOptions.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC);
                break;
        }
        Shape shape = options.getShape();
        if (shape != null) {
            requestBuilder.apply(RequestOptions.bitmapTransform(shape.getShape() == Shape.RING ? new CircleCrop():new RoundedCorners(shape.getCorners())));
        }
        //设置是否跳过缓存
        boolean isSkipMemoryCache = (mGlobalConfig != null && mGlobalConfig.isSkipMemoryCache()) || options.isSkipMemoryCache();
        requestOptions.skipMemoryCache(isSkipMemoryCache);
        requestBuilder.apply(requestOptions).into(options.getTargetContainer());
    }

    private static class ClearDiskCache implements Runnable {

        private Context mContext;

        public ClearDiskCache(Context context) {
            this.mContext = context;
        }

        @Override
        public void run() {
            //需要在子线程操作
            Glide.get(mContext).clearDiskCache();
        }
    }
}
