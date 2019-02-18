package com.pullein.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.library.image.ImageLoader;
import com.library.image.core.ImageOptions;

public class SingleNetPicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_net_pic);
        String path = "http://bbs.qn.img-space.com/201902/18/7efa8fb00237d0a38b924097acbf4c2b.jpg";
        ImageView imageView = findViewById(R.id.imageView);
        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView, path)
                .setDefaultResId(R.drawable.def)
                .setBlankResId(R.drawable.blank)
                .setErrorResId(R.drawable.error)
//                .setImageSize(950, 500)
                .build());
    }
}
