package com.library.image.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * NormalImageLoader<br>
 * describe ：Bitmap 工具类
 *
 * @author xugang
 * @date 2019/3/18
 */
public class BitmapUtils {

    /**
     * 高斯模糊，API 17 以及以上版本使用
     *
     * @param context   上下文对象
     * @param oldBitmap 需要模糊的目标Bitmap
     * @param fuzzy     模糊度0-25之间
     * @return 高斯模糊之后的Bitmap
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap gaussFuzzy(Context context, Bitmap oldBitmap, int fuzzy) {
        Bitmap inputBitmap = Bitmap.createScaledBitmap(oldBitmap, oldBitmap.getWidth() / 2, oldBitmap.getHeight() / 2, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createCubemapFromBitmap(rs, outputBitmap);

        fuzzy = fuzzy < 0 ? 0 : fuzzy > 25 ? 25 : fuzzy;
        blurScript.setRadius(fuzzy);
        blurScript.setInput(tmpIn);
        blurScript.forEach(tmpOut);

        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }
}
