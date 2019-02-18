package com.library.image.core;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

/**
 * NormalImageLoader<br>
 * describe ：Glide 简单实现
 *
 * @author xugang
 * @date 2019/2/18
 */
public class GlideLoader implements IImageLoaderStrategy {
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
        if (options.getBlankDrawable() != null) {
            requestOptions.fallback(options.getBlankDrawable());
        }
        if (options.getDefaultDrawable() != null) {
            requestOptions.placeholder(options.getDefaultDrawable());
        }
        if (options.getErrorDrawable() != null) {
            requestOptions.error(options.getErrorDrawable());
        }
        if (options.getImageSize() != null) {
            requestOptions.override(options.getImageSize().getWidth(), options.getImageSize().getHeight());
        }
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
