package com.pullein.image;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.library.image.ImageLoader;
import com.library.image.core.OnProgressListener;

import java.util.List;

/**
 * NormalImageLoader<br>
 * describe ：
 *
 * @author xugang
 * @date 2019/2/18
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MulNetPicActivity.MulPicBean> mList;

    public MyAdapter(List<MulNetPicActivity.MulPicBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MulNetPicActivity.MulPicBean mulPicBean = mList.get(i);
        myViewHolder.textView.setText(mulPicBean.getInfo());
        ImageLoader.getInstance().show(mulPicBean.getUrl(), myViewHolder.imageView, new OnProgressListener() {
            @Override
            public void onProgress(int progress) {
                myViewHolder.itemView.post(new Runnable() {
                    @Override
                    public void run() {
                        myViewHolder.textView3.setText("下载进度:" + progress + "/100");
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        TextView textView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView3 = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
