package com.library.image.core.glide;

import com.library.image.core.OnProgressListener;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * NormalImageLoader<br>
 * describe ：
 *
 * @author xugang
 * @date 2019/2/21
 */
public class GlideProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;

    private ResponseBody responseBody;

    private String url;

    private OnProgressListener listener;

    public GlideProgressResponseBody(ResponseBody responseBody, String url) {
        this.responseBody = responseBody;
        this.url = url;
        this.listener = GlideLoader.getInstance().getProgressListener(url);
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(new ProgressSource(responseBody.source()));
        }
        return bufferedSource;
    }

    private class ProgressSource extends ForwardingSource {

        long totalBytesRead = 0;

        int currentProgress;

        ProgressSource(Source source) {
            super(source);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            long bytesRead = super.read(sink, byteCount);
            long fullLength = responseBody.contentLength();
            if (bytesRead == -1) {
                totalBytesRead = fullLength;
            } else {
                totalBytesRead += bytesRead;
            }
            int progress = (int) (100 * totalBytesRead / fullLength);
            if (listener != null && progress != currentProgress) {
                listener.onProgress(progress);
            }
            if (listener != null && totalBytesRead == fullLength) {
                GlideLoader.getInstance().removeProgressListener(url);
                listener = null;
                url = null;
            }
            currentProgress = progress;
            return bytesRead;
        }
    }
}
