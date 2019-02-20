package com.library.image.core.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.library.image.core.annotation.DiskCacheStrategy.DISK_CACHE_ALL;
import static com.library.image.core.annotation.DiskCacheStrategy.DISK_CACHE_DEFAULT;
import static com.library.image.core.annotation.DiskCacheStrategy.DISK_CACHE_NONE;
import static com.library.image.core.annotation.DiskCacheStrategy.DISK_CACHE_RESULT;
import static com.library.image.core.annotation.DiskCacheStrategy.DISK_CACHE_SOURCE;


/**
 * NormalImageLoader<br>
 * describe ：磁盘缓存策略
 *
 * @author xugang
 * @date 2019/2/20
 */
@IntDef({DISK_CACHE_DEFAULT, DISK_CACHE_ALL, DISK_CACHE_NONE, DISK_CACHE_SOURCE, DISK_CACHE_RESULT})
@Retention(RetentionPolicy.SOURCE)
public @interface DiskCacheType {
}
