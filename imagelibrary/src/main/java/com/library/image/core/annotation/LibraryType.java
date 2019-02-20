package com.library.image.core.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.library.image.core.annotation.ImageLibrary.TYPE_GLIDE;

/**
 * NormalImageLoader<br>
 * describe ：可选三方库名
 *
 * @author xugang
 * @date 2019/2/20
 */
@IntDef({TYPE_GLIDE})
@Retention(RetentionPolicy.SOURCE)
public @interface LibraryType {
}
