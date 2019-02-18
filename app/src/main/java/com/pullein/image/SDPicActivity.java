package com.pullein.image;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.library.image.ImageLoader;
import com.library.image.core.ImageOptions;

public class SDPicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdpic);
        ImageView imageView = findViewById(R.id.imageView);
        Uri uri = getIntent().getData();
        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView, uri)
                .setDefaultColorId(Color.GRAY)
                .setErrorResId(R.drawable.error)
                .build());
    }
}
