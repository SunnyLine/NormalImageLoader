package com.pullein.image;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.library.image.ImageLoader;
import com.library.image.core.ImageOptions;

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        String url = "http://n1.itc.cn/img8/wb/recom/2016/06/28/146711763406564386.GIF";

        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView1, R.drawable.timg)
                .setGif(true)
                .setDefaultColorId(Color.GRAY)
                .setErrorResId(R.drawable.error)
                .build());
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView2, url)
                .setGif(true)
                .setDefaultColorId(Color.GRAY)
                .setErrorResId(R.drawable.error)
                .build());
    }
}
