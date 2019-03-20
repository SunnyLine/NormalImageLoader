package com.library.image.core.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.library.image.core.Shape.RECTANGLE;
import static com.library.image.core.Shape.RING;


/**
 * NormalImageLoader<br>
 * describe ：矩形形状
 *
 * @author xugang
 * @date 2019/3/18
 */
@IntDef({RECTANGLE, RING})
@Retention(RetentionPolicy.SOURCE)
public @interface ShapeType {
}
