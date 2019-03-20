package com.pullein.image;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.library.image.ImageLoader;
import com.library.image.core.ImageOptions;
import com.library.image.core.Shape;

/**
 * ShapeActivity.java<br>
 * describe : 展示各种形状的图片
 *
 * @author xugang
 * @date 2019/3/20
 */
public class ShapeActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBarBlur;
    private SeekBar seekBarStrokeWidth;
    private SeekBar seekBarAngle;
    private SeekBar seekBarAlpha;
    private ImageView imageView;
    private EditText editTextStrokeColor;
    private CheckBox checkBoxRing;
    private TextView tvAlpha;
    private TextView tvAngle;
    private TextView tvStrokeWidth;
    private TextView tvBlur;

    private Shape mShape = new Shape(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        seekBarBlur = findViewById(R.id.seekBarBlur);
        seekBarStrokeWidth = findViewById(R.id.seekBarStrokeWidth);
        seekBarAngle = findViewById(R.id.seekBarAngle);
        seekBarAlpha = findViewById(R.id.seekBarAlpha);
        imageView = findViewById(R.id.imageView3);
        editTextStrokeColor = findViewById(R.id.editTextStrokeColor);
        checkBoxRing = findViewById(R.id.checkBoxRing);
        tvAlpha = findViewById(R.id.tvAlpha);
        tvAngle = findViewById(R.id.tvAngle);
        tvStrokeWidth = findViewById(R.id.tvStrokeWidth);
        tvBlur = findViewById(R.id.tvBlur);


        seekBarAngle.setOnSeekBarChangeListener(this);
        seekBarStrokeWidth.setOnSeekBarChangeListener(this);
        seekBarBlur.setOnSeekBarChangeListener(this);
        seekBarAlpha.setOnSeekBarChangeListener(this);

        checkBoxRing.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mShape.setShape(isChecked ? Shape.RING : Shape.RECTANGLE);
            show();
        });
    }

    public void onClick(View view) {
        String str = editTextStrokeColor.getText().toString().trim();
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            Toast.makeText(this, "输入正确的颜色值", Toast.LENGTH_SHORT).show();
            return;
        }
        String color = "#" + str;
        mShape.setStokeColorId(Color.parseColor(color));
        show();
    }


    private void show() {
        ImageLoader.getInstance().show(new ImageOptions.Builder(imageView, R.mipmap.a).setShape(mShape).build());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.seekBarBlur:
                tvBlur.setText(String.valueOf(seekBar.getProgress()));
                break;
            case R.id.seekBarStrokeWidth:
                tvStrokeWidth.setText(getString(R.string.dimension, seekBar.getProgress()));
                break;
            case R.id.seekBarAngle:
                int progress = seekBar.getProgress();
                if (progress == 0){
                    progress = 1;
                }
                tvAngle.setText(String.valueOf(progress));
                mShape.setCorners(progress);
                show();
                break;
            case R.id.seekBarAlpha:
                tvAlpha.setText(getString(R.string.percentage, seekBar.getProgress()));
                break;
            default:
                break;
        }
    }
}
