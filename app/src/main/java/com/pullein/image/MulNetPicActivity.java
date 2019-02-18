package com.pullein.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MulNetPicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_net_pic);
        RecyclerView recycler = findViewById(R.id.recycler);
        MyAdapter adapter = new MyAdapter(createData());
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    private List<MulPicBean> createData() {
        List<MulPicBean> list = new ArrayList<>();
        list.add(new MulPicBean("云南行摄之一-----神秘、多彩的泸沽湖", "http://bbs.qn.img-space.com/201902/16/c8de1610d6cf4e33b9e1bc0e9e7240ff.jpg"));
        list.add(new MulPicBean("Maputo Mozambique", "http://bbs.qn.img-space.com/201902/13/da605a25888c75c8a038e030fc30d153.jpg"));
        list.add(new MulPicBean("城中晨雾", "http://bbs.qn.img-space.com/201902/13/8f47efca93ff36efba46f40428b1fdbb.jpg"));
        list.add(new MulPicBean("行摄拉卜楞寺", "http://bbs.qn.img-space.com/201902/12/b429dc0fdbddfa88f621addfb3582b5a.jpg"));
        list.add(new MulPicBean("冬日郎木寺", "http://bbs.qn.img-space.com/201902/11/ce4ee44cbad337c980df3d2182df638b.jpg"));
        list.add(new MulPicBean("环游青海湖", "http://bbs.qn.img-space.com/201902/6/30ca51e6c1c41e976c6dc459ca0da5d1.jpg"));
        list.add(new MulPicBean("四川若尔盖草原秋色", "http://bbs.qn.img-space.com/201902/3/52db9837ddcdb7d26c1aab672f828153.jpg"));
        list.add(new MulPicBean("Monument Valley Park, 纪念碑谷公园", "http://bbs.qn.img-space.com/201902/1/587ed9fc075cffb41b4ea381c9634901.jpg"));
        list.add(new MulPicBean("周星驰电影《美人鱼》中的青锣湾——深圳鹿嘴", "http://bbs.qn.img-space.com/201901/30/3f824bece78c17e55d70101a19eeaa9e.jpg"));
        list.add(new MulPicBean("日落阿尔卑斯山", "http://bbs.qn.img-space.com/201901/25/21d9a97530c15202dd25eb5202cef68b.jpg"));
        list.add(new MulPicBean("探秘冰雪北疆，自驾寻找最美冬季", "http://bbs.qn.img-space.com/201901/22/2b77fd2e19b89b7295d4c6151458c42c.jpg"));
        list.add(new MulPicBean("探秘冰雪北疆，自驾寻找最美冬季", "http://bbs.qn.img-space.com/201901/22/6396037fb083145eb53f2d5dd7ef998b.jpg"));
        list.add(new MulPicBean("初冬皖南古村游——家朋镇坎头古村", "http://bbs.qn.img-space.com/201901/14/5db07a92c32d2485bb4982547a050e8d.jpg"));
        list.add(new MulPicBean("8月自驾新疆，冬天才翻出来开始修几张瞧瞧！", "http://bbs.qn.img-space.com/201901/7/29f5a5423a021ab4eb3477e481cad210.jpg"));
        list.add(new MulPicBean("阿坝/格尔登的“莫郎节”法会场面盛大，气势如虹", "http://bbs.qn.img-space.com/201901/6/92b9b9048856bb8c6a1ad2dd1530b066.jpg"));
        return list;
    }

    class MulPicBean {
        private String info;
        private String url;

        public MulPicBean(String info, String url) {
            this.info = info;
            this.url = url;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "MulPicBean{" +
                    "info='" + info + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
