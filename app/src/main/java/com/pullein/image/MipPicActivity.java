package com.pullein.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.library.image.ImageLoader;

public class MipPicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mip_pic);
        ImageView imageView1 = findViewById(R.id.image1);
        ImageView imageView2 = findViewById(R.id.image2);
        ImageView imageView3 = findViewById(R.id.image3);
        ImageView imageView4 = findViewById(R.id.image4);
        ImageView imageView5 = findViewById(R.id.image5);
        ImageLoader.getInstance().show(R.mipmap.ic_launcher, imageView1);
        ImageLoader.getInstance().show(R.mipmap.a, imageView2);
        ImageLoader.getInstance().show(R.mipmap.b, imageView3);
        ImageLoader.getInstance().show(R.mipmap.c, imageView4);
        ImageLoader.getInstance().show(R.mipmap.d, imageView5);
    }
}
