package com.library.image.core.glide;

import android.util.Log;

import com.library.image.core.OnProgressListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * NormalImageLoader<br>
 * describe ：
 *
 * @author xugang
 * @date 2019/2/21
 */
public class GlideProgressInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        ResponseBody body = response.body();
        return response.newBuilder().body(new GlideProgressResponseBody(body, new OnProgressListener() {
            @Override
            public void onProgress(int progress) {
                Log.d("===============", "progress:" + progress);
            }
        })).build();
    }
}
