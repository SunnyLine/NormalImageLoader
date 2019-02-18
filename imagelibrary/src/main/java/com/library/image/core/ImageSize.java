package com.library.image.core;

/**
 * NormalImageLoader<br>
 * describe : 设置图片大小
 *
 * @author xugang
 * @date 2019/2/18
 */
public class ImageSize {
    private int width;
    private int height;

    /**
     * @param width  The width in pixels to use to load the resource.
     * @param height height The height in pixels to use to load the resource.
     * @return
     */
    public ImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
