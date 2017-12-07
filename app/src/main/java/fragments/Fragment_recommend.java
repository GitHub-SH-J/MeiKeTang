package fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.best.meiketang.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import json.Json;
import utils.HttpUtils;
import utils.JsonUtils;

/**
 * Created by best on 2017/12/4.
 */

public class Fragment_recommend extends Fragment implements HttpUtils.findMessage {
    private String path = "http://api.dameiketang.com/manager.php?m=Admin&c=Newshow&a=user_lesson_type_id";
    private String path1 = "http://api.dameiketang.com/manager.php?m=Admin&c=Threevesion&a=IndexPageData";
    private String id = "6894681b-ad8b-47e4-9f17-1cf07324464c";
    private ArrayList<String> list;
    private HashMap<String, String> map = new HashMap<>();
    private ArrayList<ImageView> lists = new ArrayList<>();
    private HttpUtils utils;
    private MyPager adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 11) {
                int index = mViewPager.getCurrentItem();
                index++;
                handler.sendEmptyMessageDelayed(11, 2000);
                mViewPager.setCurrentItem(index);
            }
        }
    };
    private ViewPager mViewPager;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommend, null);
        utils = new HttpUtils(this);
        initView();
        getSendMessage();
        getAllMessage();
        find();
        return view;
    }

    private void initView() {
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
    }


    private void find() {
        mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        adapter = new MyPager();
        mViewPager.setAdapter(adapter);
        handler.sendEmptyMessageDelayed(11, 1000);
    }


    //获取所有的数据
    private void getAllMessage() {
        map.clear();
        map.put("id", id);
        utils.postReposenTwo(path1, map);
    }

    //点击的数据
    private void getSendMessage() {
        list = getActivity().getIntent().getStringArrayListExtra("list");
        if (list != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    sb.append(list.get(i));
                    continue;
                } else {
                    sb.append(list.get(i) + ",");
                }
            }
            String str = new String(sb);
            map.put("id", "6894681b-ad8b-47e4-9f17-1cf07324464c");
            map.put("type_id", str);
            utils.postReposen(path, map);
        }
    }

    @Override
    public void getString(String str, int tag) {
        if (tag == 0625) {
            Gson gson = new Gson();
            Json json1 = gson.fromJson(str, Json.class);
            List<Json.EBean> elist = json1.getE();
            for (int i = 0; i < elist.size(); i++) {
                ImageView img = new ImageView(getContext());
                img.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
                Picasso.with(getActivity()).load(elist.get(i).getImgurl()).into(img);
                lists.add(img);
            }
            if (lists != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    class MyPager extends PagerAdapter {


        @Override
        public int getCount() {
            if (lists.size() > 0) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View v = lists.get(position % lists.size());
            ViewGroup view = (ViewGroup) v.getParent();
            if (view != null) {
                view.removeView(v);
            }
            container.addView(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent=new Intent(getActivity(), DetialActivity.class);
                    long id=ll.get(position%lists.size());
                    intent.putExtra("id",id);
                    startActivity(intent);*/
                }
            });
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}

