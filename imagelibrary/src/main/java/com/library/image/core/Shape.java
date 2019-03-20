package com.library.image.core;

import android.support.annotation.ColorInt;

import com.library.image.core.annotation.ShapeType;

/**
 * NormalImageLoader<br>
 * describe ：形状设置
 *
 * @author xugang
 * @date 2019/3/20
 */
public class Shape {
    /**
     * 矩形 ，可以设置圆角，描边等
     */
    public final static int RECTANGLE = 1;
    /**
     * 环形，可以设置描边
     */
    public final static int RING = 2;

    private @ShapeType
    int shape;
    /**
     * 描边颜色
     */
    private @ColorInt
    int stokeColorId;
    /**
     * 描边宽度
     */
    private int stokeWidth;
    /**
     * 矩形的角度
     */
    private int corners;

    /**
     * 透明度0-100,100不透明，50半透明
     */
    private int transparency;
    /**
     * 高斯模糊度0-100
     */
    private int fuzzy;

    public Shape() {
        this.shape = Shape.RING;
    }

    public Shape(int corners) {
        this.shape = Shape.RECTANGLE;
        this.corners = corners;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getStokeColorId() {
        return stokeColorId;
    }

    public void setStokeColorId(int stokeColorId) {
        this.stokeColorId = stokeColorId;
    }

    public int getStokeWidth() {
        return stokeWidth;
    }

    public void setStokeWidth(int stokeWidth) {
        this.stokeWidth = stokeWidth;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(int fuzzy) {
        this.fuzzy = fuzzy;
    }
}
