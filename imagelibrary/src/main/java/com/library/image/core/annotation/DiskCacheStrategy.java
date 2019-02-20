package com.library.image.core.annotation;

/**
 * NormalImageLoader<br>
 * describe ：磁盘缓存策略
 *
 * @author xugang
 * @date 2019/2/20
 */
public interface DiskCacheStrategy {
    /**
     * 默认缓存模式
     */
    int DISK_CACHE_DEFAULT = 0x001;
    /**
     * 缓存所有图片(原图和压缩后的图片)
     */
    int DISK_CACHE_ALL = 0x002;
    /**
     * 不缓存
     */
    int DISK_CACHE_NONE = 0x003;
    /**
     * 直接缓存原图片
     */
    int DISK_CACHE_SOURCE = 0x004;
    /**
     * 缓存压缩后的图片
     */
    int DISK_CACHE_RESULT = 0x005;

}
