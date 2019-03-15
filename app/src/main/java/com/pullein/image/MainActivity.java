package com.pullein.image;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.library.image.ImageLoader;
import com.library.image.core.annotation.ImageLibrary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this, MipPicActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, SingleNetPicActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, MulNetPicActivity.class));
                break;
            case R.id.button4:
                Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                // 设置数据类型为图片类型
                choiceFromAlbumIntent.setType("image/*");
                startActivityForResult(Intent.createChooser(choiceFromAlbumIntent, "Select File"), 1002);
                break;
            case R.id.button5:
                ImageLoader.getInstance().clearMemory(this);
                Toast.makeText(this, "清除内存缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                ImageLoader.getInstance().clearDiskCache(this);
                Toast.makeText(this, "子线程清理SD卡缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button7:
                startActivity(new Intent(this, GifActivity.class));
                break;
            case R.id.button8:
                Toast.makeText(this, "图片处理(圆角，高斯模糊)暂时未完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button9:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && 1002 == requestCode && data != null) {
            data.setClass(this, SDPicActivity.class);
            startActivity(data);
        }
    }
}
