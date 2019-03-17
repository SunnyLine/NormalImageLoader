package com.pullein.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.library.image.ImageLoader;
import com.library.image.core.ImageOptions;
import com.library.image.core.OnProgressListener;

/**
 * 显示加载进度
 */
public class ProgressPicActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ImageView imageView4;
    private TextView textView2;
    private String imageUrl = "http://img8.zol.com.cn/bbs/upload/21213/21212551.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_pic);

        progressBar = findViewById(R.id.progressBar);
        imageView4 = findViewById(R.id.imageView4);
        textView2 = findViewById(R.id.textView2);

        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView4, imageUrl).setOnProgressListener(new OnProgressListener() {
            @Override
            public void onProgress(int progress) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(progress);
                        textView2.setText("下载进度:" + progress + "/100");
                    }
                });
            }
        }).build());
    }
}
