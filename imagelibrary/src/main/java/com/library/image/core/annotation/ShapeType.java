package com.library.image.core.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;
import static android.graphics.drawable.GradientDrawable.RING;

/**
 * NormalImageLoader<br>
 * describe ：
 *
 * @author xugang
 * @date 2019/3/18
 */
@IntDef({RECTANGLE, RING})
@Retention(RetentionPolicy.SOURCE)
public @interface ShapeType {
}
