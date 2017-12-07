package guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.best.meiketang.MainActivity;
import com.example.best.meiketang.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import json.Json;

public class Guide_page extends AppCompatActivity implements View.OnClickListener {
    private ImageView aihaozhe, meiyezhe, ball_one, ball_two, ball_three, ball_four,
            ball_chuxuezhe, ball_jingyingzhe, ball_zaizhizhe,
            obchuazhuang, obcmeijia, obcmeifa, obcmeirong, obcmeixue, huazhuang, meijia, meifa, meirong, meixue,
            zaizhizhe_huazhuang_selete, zaizhizhe_meijia_selete, zaizhizhe_meifa_selete, zaizhizhe_meirong_selete, zaizhizhe_meixue_selete,
            yejibeizeng, jingyingguanli, caiwuguanli, zibenyunzuo, qiyewenhua, tuanduijianshe;
    private TextView selete_tv;
    private TextView shenfen_tv;
    private TextView jieshao_tv;
    private TextView back_Tv;
    private Button kaiqi_aihaozhe_btn, kaiqi_meiyeren_Btn;
    private boolean aihaozhe1 = true;
    private boolean aihaozhe2 = true;
    private boolean aihaozhe3 = true;
    private boolean aihaozhe4 = true;
    private boolean bool1 = true;
    private boolean bool2 = true;
    private boolean bool3 = true;
    private boolean bool4 = true;
    private boolean bool5 = true;
    private boolean flag1 = true;
    private boolean flag2 = true;
    private boolean flag3 = true;
    private boolean flag4 = true;
    private boolean flag5 = true;
    private boolean jy1 = true;
    private boolean jy2 = true;
    private boolean jy3 = true;
    private boolean jy4 = true;
    private boolean jy5 = true;
    private boolean jy6 = true;
    private ArrayList<String> list = new ArrayList<>();
    private Json json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        initView();
        initWorkData();
    }

    private void initWorkData() {
        try {
            InputStream open = this.getAssets().open("curstom.json");
            StringBuffer sb = new StringBuffer();
            int i;
            byte[] by = new byte[1024];
            while ((i = open.read(by)) != -1) {
                sb.append(new String(by, 0, i));
            }
            String str = String.valueOf(sb);
            json = new Gson().fromJson(str, Json.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        /**
         * Button按钮
         */
        kaiqi_aihaozhe_btn = (Button) findViewById(R.id.kaiqi_aihaozhe_Btn);
        kaiqi_meiyeren_Btn = (Button) findViewById(R.id.kaiqi_meiyeren_Btn);
        /**
         * TextView
         */
        selete_tv = (TextView) findViewById(R.id.selete_Tv);
        shenfen_tv = (TextView) findViewById(R.id.shenfen_Tv);
        jieshao_tv = (TextView) findViewById(R.id.jieshao_Tv);
        back_Tv = (TextView) findViewById(R.id.back_Tv);
        /**
         * ImageView
         */
        aihaozhe = (ImageView) findViewById(R.id.aihaozhe);
        meiyezhe = (ImageView) findViewById(R.id.meiyezhe);
        ball_one = (ImageView) findViewById(R.id.ball_one);
        ball_two = (ImageView) findViewById(R.id.ball_two);
        ball_three = (ImageView) findViewById(R.id.ball_three);
        ball_four = (ImageView) findViewById(R.id.ball_four);
        ball_chuxuezhe = (ImageView) findViewById(R.id.ball_chuxuezhe);
        ball_jingyingzhe = (ImageView) findViewById(R.id.ball_jingyingzhe);
        ball_zaizhizhe = (ImageView) findViewById(R.id.ball_zaizhizhe);
        obchuazhuang = (ImageView) findViewById(R.id.ball_huazhuang);
        obcmeijia = (ImageView) findViewById(R.id.ball_meijia);
        obcmeifa = (ImageView) findViewById(R.id.ball_meifa);
        obcmeirong = (ImageView) findViewById(R.id.ball_meirong);
        obcmeixue = (ImageView) findViewById(R.id.ball_meixue);
        huazhuang = (ImageView) findViewById(R.id.zaizhizhe_huazhuang);
        meijia = (ImageView) findViewById(R.id.zaizhizhe_meijia);
        meifa = (ImageView) findViewById(R.id.zaizhizhe_meifa);
        meirong = (ImageView) findViewById(R.id.zaizhizhe_meirong);
        meixue = (ImageView) findViewById(R.id.zaizhizhe_meixue);
        /**
         * 经营者弹窗
         */
        yejibeizeng = (ImageView) findViewById(R.id.yejibeizeng);
        jingyingguanli = (ImageView) findViewById(R.id.jingyingguanli);
        caiwuguanli = (ImageView) findViewById(R.id.caiwuguanli);
        zibenyunzuo = (ImageView) findViewById(R.id.zibenyunzuo);
        qiyewenhua = (ImageView) findViewById(R.id.qiyewenhua);
        tuanduijianshe = (ImageView) findViewById(R.id.tuanduijianshe);
        /**
         * 在职者选择图
         */
        zaizhizhe_huazhuang_selete = (ImageView) findViewById(R.id.zaizhizhe_huahzuang_selete);
        zaizhizhe_meijia_selete = (ImageView) findViewById(R.id.zaizhizhe_meijia_selete);
        zaizhizhe_meifa_selete = (ImageView) findViewById(R.id.zaizhizhe_meifa_selete);
        zaizhizhe_meirong_selete = (ImageView) findViewById(R.id.zaizhizhe_meirong_selete);
        zaizhizhe_meixue_selete = (ImageView) findViewById(R.id.zaizhizhe_meixue_selete);
        /**
         * 点击事件
         */
        obchuazhuang.setOnClickListener(this);
        obcmeijia.setOnClickListener(this);
        obcmeifa.setOnClickListener(this);
        obcmeirong.setOnClickListener(this);
        obcmeixue.setOnClickListener(this);
        ball_chuxuezhe.setOnClickListener(this);
        ball_jingyingzhe.setOnClickListener(this);
        ball_zaizhizhe.setOnClickListener(this);
        ball_one.setOnClickListener(this);
        ball_two.setOnClickListener(this);
        ball_three.setOnClickListener(this);
        ball_four.setOnClickListener(this);
        aihaozhe.setOnClickListener(this);
        meiyezhe.setOnClickListener(this);
        selete_tv.setOnClickListener(this);
        back_Tv.setOnClickListener(this);
        huazhuang.setOnClickListener(this);
        meijia.setOnClickListener(this);
        meifa.setOnClickListener(this);
        meirong.setOnClickListener(this);
        meixue.setOnClickListener(this);
        tuanduijianshe.setOnClickListener(this);
        yejibeizeng.setOnClickListener(this);
        jingyingguanli.setOnClickListener(this);
        caiwuguanli.setOnClickListener(this);
        zibenyunzuo.setOnClickListener(this);
        qiyewenhua.setOnClickListener(this);
        kaiqi_aihaozhe_btn.setOnClickListener(this);
    }

    /**
     * 各种点击事件监听
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aihaozhe:
                meiyezhe.setEnabled(false);
                aihaozhe.setEnabled(false);
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(aihaozhe, "translationX", -200, 0);
                animatorX.setDuration(1000);
                ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(meiyezhe, "translationX", 200, 0);
                animatorX1.setDuration(1000);

                AnimatorSet set = new AnimatorSet();
                set.play(animatorX).with(animatorX1);
                set.start();
                shenfen_tv.setText("兴趣选择");
                jieshao_tv.setText("请选择感兴趣的修炼魔法");
                kaiqi_aihaozhe_btn.setVisibility(View.VISIBLE);
                animatorX.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        meiyezhe.setVisibility(View.GONE);
//                        aihaozhe.setEnabled(false);
                        ball_one.setVisibility(View.VISIBLE);
                        ball_two.setVisibility(View.VISIBLE);
                        ball_three.setVisibility(View.VISIBLE);
                        ball_four.setVisibility(View.VISIBLE);
                        ObjectAnimator rightX = ObjectAnimator.ofFloat(ball_one, "translationX", 0, 300f);
                        ObjectAnimator rightY = ObjectAnimator.ofFloat(ball_one, "translationY", 0, -100f);

                        ObjectAnimator leftX = ObjectAnimator.ofFloat(ball_two, "translationX", 0, -300f);
                        ObjectAnimator leftY = ObjectAnimator.ofFloat(ball_two, "translationY", 0, -100f);

                        ObjectAnimator right_TopX = ObjectAnimator.ofFloat(ball_three, "translationX", 0, -150f);
                        ObjectAnimator right_TopY = ObjectAnimator.ofFloat(ball_three, "translationY", 0, -290f);

                        ObjectAnimator left_TopX = ObjectAnimator.ofFloat(ball_four, "translationX", 0, 150f);
                        ObjectAnimator left_TopY = ObjectAnimator.ofFloat(ball_four, "translationY", 0, -290f);

                        AnimatorSet set1 = new AnimatorSet();
                        set1.setDuration(1000);
                        set1.play(rightX).with(rightY).with(leftX).with(leftY).with(right_TopX).with(right_TopY).with(left_TopX).with(left_TopY);
                        set1.start();
                    }
                });
                break;
            case R.id.meiyezhe:
                aihaozhe.setEnabled(false);
                meiyezhe.setEnabled(false);
                animatorX = ObjectAnimator.ofFloat(aihaozhe, "translationX", -200, 0);
                animatorX.setDuration(1000);
                animatorX1 = ObjectAnimator.ofFloat(meiyezhe, "translationX", 200, 0);
                animatorX1.setDuration(1000);
                set = new AnimatorSet();
                set.play(animatorX).with(animatorX1);
                set.start();
                shenfen_tv.setText("技能等级");
                jieshao_tv.setText("请根据您的实际情况选择技能等级");

                animatorX.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        aihaozhe.setVisibility(View.GONE);
//                        meiyezhe.setEnabled(false);
                        ball_chuxuezhe.setVisibility(View.VISIBLE);
                        ball_jingyingzhe.setVisibility(View.VISIBLE);
                        ball_zaizhizhe.setVisibility(View.VISIBLE);
                        ObjectAnimator animatorY = ObjectAnimator.ofFloat(meiyezhe, "translationY", 0, -80);
                        animatorY.setDuration(1000);

                        ObjectAnimator dwonY = ObjectAnimator.ofFloat(ball_zaizhizhe, "translationY", 0, 300f);

                        ObjectAnimator dwon_leftY = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationY", 0, 300f);
                        ObjectAnimator dwon_leftX = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationX", 0, -200f);

                        ObjectAnimator dwon_rightY = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationY", 0, 300f);
                        ObjectAnimator dwon_rightX = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationX", 0, 200f);
                        AnimatorSet set2 = new AnimatorSet();
                        set2.setDuration(2000);
                        set2.play(dwonY).with(dwon_leftY).with(dwon_leftX).with(dwon_rightY).with(dwon_rightX).with(animatorY);
                        set2.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
            case R.id.selete_Tv:
                onStart();
                meiyezhe.setVisibility(View.VISIBLE);
                aihaozhe.setVisibility(View.VISIBLE);
                aihaozhe.setEnabled(true);
                meiyezhe.setEnabled(true);
                shenfen_tv.setText("身份选择");
                jieshao_tv.setText("请小仙女选择一个在美课堂的身份吧");
                ball_one.setVisibility(View.GONE);
                ball_two.setVisibility(View.GONE);
                ball_three.setVisibility(View.GONE);
                ball_four.setVisibility(View.GONE);
                ball_zaizhizhe.setVisibility(View.GONE);
                ball_jingyingzhe.setVisibility(View.GONE);
                ball_chuxuezhe.setVisibility(View.GONE);
                kaiqi_aihaozhe_btn.setVisibility(View.GONE);
                break;
            //TODO 爱好者化妆
            case R.id.ball_one:
                if (aihaozhe1) {
                    ball_one.setImageResource(R.mipmap.shenghuoxiuxian_select);
//                    list.add(json.getT().get生活休闲().getId());
                    aihaozhe1 = false;
                } else {
                    ball_one.setImageResource(R.mipmap.shenghuoxiuxian);
//                    list.remove(json.getT().get生活休闲().getId());
                    aihaozhe1 = true;
                }
                break;
            case R.id.ball_two:
                if (aihaozhe2) {
                    ball_two.setImageResource(R.mipmap.suxingyuyangsheng_select);
//                    list.add(json.getT().get塑形养生().getId());
                    aihaozhe2 = false;
                } else {
                    ball_two.setImageResource(R.mipmap.suxingyuyangsheng);
//                    list.remove(json.getT().get塑形养生().getId());
                    aihaozhe2 = true;
                }
                break;
            case R.id.ball_three:
                if (aihaozhe3) {
                    ball_three.setImageResource(R.mipmap.zhichangjingying_select);
//                    list.add(json.getT().get职场().getId());
                    aihaozhe3 = false;
                } else {
                    ball_three.setImageResource(R.mipmap.zhichangjingying);
//                    list.remove(json.getT().get职场().getId());
                    aihaozhe3 = true;
                }
                break;
            case R.id.ball_four:
                if (aihaozhe4) {
                    ball_four.setImageResource(R.mipmap.zhutihuodong_select);
//                    list.add(json.getT().get主题活动().getId());
                    aihaozhe4 = false;
                } else {
                    ball_four.setImageResource(R.mipmap.zhutihuodong);
//                    list.remove(json.getT().get主题活动().getId());
                    aihaozhe4 = true;
                }
                break;
            case R.id.ball_chuxuezhe:
                ObjectAnimator up_rightX = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationX", -200, 0);
                ObjectAnimator up_rightY = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationY", 300, 0);

                AnimatorSet set3 = new AnimatorSet();
                set3.setDuration(2000);
                set3.play(up_rightX).with(up_rightY);
                set3.start();
                meiyezhe.setVisibility(View.GONE);
                ball_zaizhizhe.setVisibility(View.GONE);
                ball_jingyingzhe.setVisibility(View.GONE);
                selete_tv.setVisibility(View.GONE);
                back_Tv.setVisibility(View.VISIBLE);
                set3.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        obchuazhuang.setVisibility(View.VISIBLE);
                        obcmeijia.setVisibility(View.VISIBLE);
                        obcmeifa.setVisibility(View.VISIBLE);
                        obcmeirong.setVisibility(View.VISIBLE);
                        obcmeixue.setVisibility(View.VISIBLE);
                        kaiqi_meiyeren_Btn.setVisibility(View.VISIBLE);

                        ObjectAnimator huazhuang = ObjectAnimator.ofFloat(obchuazhuang, "translationX", 0, -300f);

                        ObjectAnimator meijiaX = ObjectAnimator.ofFloat(obcmeijia, "translationX", 0, -200f);
                        ObjectAnimator meijiaY = ObjectAnimator.ofFloat(obcmeijia, "translationY", 0, -250f);

                        ObjectAnimator meifaX = ObjectAnimator.ofFloat(obcmeifa, "translationX", 0, 200f);
                        ObjectAnimator meifaY = ObjectAnimator.ofFloat(obcmeifa, "translationY", 0, -250f);

                        ObjectAnimator meirong = ObjectAnimator.ofFloat(obcmeirong, "translationX", 0, 300f);

                        ObjectAnimator meixueX = ObjectAnimator.ofFloat(obcmeixue, "translationX", 0, 200f);
                        ObjectAnimator meixueY = ObjectAnimator.ofFloat(obcmeixue, "translationY", 0, 250f);


                        AnimatorSet set4 = new AnimatorSet();
                        set4.setDuration(2000);
                        set4.play(huazhuang).with(meijiaX).with(meijiaY).with(meifaX).with(meifaY).with(meirong).with(meixueX).with(meixueY);
                        set4.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                ObjectAnimator leftX = ObjectAnimator.ofFloat(obchuazhuang, "translationX", 0, -300f);

                AnimatorSet set4 = new AnimatorSet();
                set4.setDuration(2000);
                set4.play(leftX);
                set4.start();

                break;
            //在职者动画
            case R.id.ball_zaizhizhe:
                ObjectAnimator up_upY = ObjectAnimator.ofFloat(ball_zaizhizhe, "translationY", 300, 0);

                AnimatorSet zaizhizhe_set = new AnimatorSet();
                zaizhizhe_set.setDuration(2000);
                zaizhizhe_set.play(up_upY);
                zaizhizhe_set.start();
                ball_chuxuezhe.setVisibility(View.GONE);
                ball_jingyingzhe.setVisibility(View.GONE);
                meiyezhe.setVisibility(View.GONE);
                selete_tv.setVisibility(View.GONE);
                back_Tv.setVisibility(View.VISIBLE);

                zaizhizhe_set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        huazhuang.setVisibility(View.VISIBLE);
                        meijia.setVisibility(View.VISIBLE);
                        meifa.setVisibility(View.VISIBLE);
                        meirong.setVisibility(View.VISIBLE);
                        meixue.setVisibility(View.VISIBLE);
                        kaiqi_meiyeren_Btn.setVisibility(View.VISIBLE);

                        ObjectAnimator zaizhi_huazhuangX = ObjectAnimator.ofFloat(huazhuang, "translationX", 0, -300f);

                        ObjectAnimator zaizhi_meijiaX = ObjectAnimator.ofFloat(meijia, "translationX", 0, -200f);
                        ObjectAnimator zaizhi_meijiaY = ObjectAnimator.ofFloat(meijia, "translationY", 0, -250f);

                        ObjectAnimator zaizhi_meifaX = ObjectAnimator.ofFloat(meifa, "translationX", 0, 200f);
                        ObjectAnimator zaizhi_meifaY = ObjectAnimator.ofFloat(meifa, "translationY", 0, -250f);

                        ObjectAnimator zaizhi_meirong = ObjectAnimator.ofFloat(meirong, "translationX", 0, 300f);

                        ObjectAnimator zaizhi_meixueX = ObjectAnimator.ofFloat(meixue, "translationX", 0, 200f);
                        ObjectAnimator zaizhi_meixueY = ObjectAnimator.ofFloat(meixue, "translationY", 0, 250f);

                        AnimatorSet zaizhizhe_T = new AnimatorSet();
                        zaizhizhe_T.setDuration(2000);
                        zaizhizhe_T.play(zaizhi_huazhuangX).with(zaizhi_meijiaX).with(zaizhi_meijiaY).with(zaizhi_meifaX)
                                .with(zaizhi_meifaY).with(zaizhi_meirong).with(zaizhi_meixueX).with(zaizhi_meixueY);
                        zaizhizhe_T.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
            case R.id.ball_jingyingzhe:
                ObjectAnimator up_left_Y = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationY", 300, 0);
                ObjectAnimator up_right_X = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationX", 200, 0);

                AnimatorSet jingyingzhe_set = new AnimatorSet();
                jingyingzhe_set.setDuration(2000);
                jingyingzhe_set.play(up_left_Y).with(up_right_X);
                jingyingzhe_set.start();
                ball_chuxuezhe.setVisibility(View.GONE);
                ball_zaizhizhe.setVisibility(View.GONE);
                meiyezhe.setVisibility(View.GONE);
                selete_tv.setVisibility(View.GONE);
                back_Tv.setVisibility(View.VISIBLE);

                jingyingzhe_set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        yejibeizeng.setVisibility(View.VISIBLE);
                        jingyingguanli.setVisibility(View.VISIBLE);
                        caiwuguanli.setVisibility(View.VISIBLE);
                        zibenyunzuo.setVisibility(View.VISIBLE);
                        qiyewenhua.setVisibility(View.VISIBLE);
                        tuanduijianshe.setVisibility(View.VISIBLE);
                        kaiqi_meiyeren_Btn.setVisibility(View.VISIBLE);

                        ObjectAnimator yejibeizengX = ObjectAnimator.ofFloat(yejibeizeng, "translationX", 0, -300f);

                        ObjectAnimator jingyingguanliX = ObjectAnimator.ofFloat(jingyingguanli, "translationX", 0, -200f);
                        ObjectAnimator jingyinggaunliY = ObjectAnimator.ofFloat(jingyingguanli, "translationY", 0, -250f);

                        ObjectAnimator caiwuguanliX = ObjectAnimator.ofFloat(caiwuguanli, "translationX", 0, 200f);
                        ObjectAnimator caiwugaunliY = ObjectAnimator.ofFloat(caiwuguanli, "translationY", 0, -250f);

                        ObjectAnimator zibenyunzuoX = ObjectAnimator.ofFloat(zibenyunzuo, "translationX", 0, 300f);

                        ObjectAnimator qiyewenhuaX = ObjectAnimator.ofFloat(qiyewenhua, "translationX", 0, 200f);
                        ObjectAnimator qiyewenhuaY = ObjectAnimator.ofFloat(qiyewenhua, "translationY", 0, 250f);
                        ObjectAnimator tuanduijiansheX = ObjectAnimator.ofFloat(tuanduijianshe, "translationX", 0, -200f);
                        ObjectAnimator tuanduijiansheY = ObjectAnimator.ofFloat(tuanduijianshe, "translationY", 0, 250f);

                        AnimatorSet jingyingzhe_T = new AnimatorSet();
                        jingyingzhe_T.setDuration(2000);
                        jingyingzhe_T.play(yejibeizengX).with(jingyingguanliX).with(jingyinggaunliY).with(caiwuguanliX)
                                .with(caiwugaunliY).with(zibenyunzuoX).with(qiyewenhuaX).with(qiyewenhuaY).with(tuanduijiansheX).with(tuanduijiansheY);
                        jingyingzhe_T.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
            case R.id.back_Tv:
                meiyezhe();
                back_Tv.setVisibility(View.GONE);
                selete_tv.setVisibility(View.VISIBLE);
                kaiqi_meiyeren_Btn.setVisibility(View.GONE);

                break;
            case R.id.ball_huazhuang:
                if (bool1) {
                    obchuazhuang.setImageResource(R.mipmap.obchuazhuang_select);
//                    list.add(json.getT().getOBC化妆().getId());
                    bool1 = false;
                } else {
                    obchuazhuang.setImageResource(R.mipmap.obchuazhuang);
//                    list.remove(json.getT().getOBC化妆().getId());
                    bool1 = true;
                }
                break;
            case R.id.ball_meijia:
                if (bool2) {
                    obcmeijia.setImageResource(R.mipmap.obcmeijia_select);
//                    list.add(json.getT().getOBC美甲().getId());
                    bool2 = false;
                } else {
                    obcmeijia.setImageResource(R.mipmap.obcmeijian);
//                    list.remove(json.getT().getOBC美甲().getId());
                    bool2 = true;
                }
                break;
            case R.id.ball_meifa:
                if (bool3) {
                    obcmeifa.setImageResource(R.mipmap.obcmeifa_select);
//                    list.add(json.getT().getOBC美发().getId());
                    bool3 = false;
                } else {
                    obcmeifa.setImageResource(R.mipmap.obcmeifa);
//                    list.remove(json.getT().getOBC美发().getId());
                    bool3 = true;
                }
                break;
            case R.id.ball_meirong:
                if (bool4) {
                    obcmeirong.setImageResource(R.mipmap.obcmeirong_select);
//                    list.add(json.getT().getOBC美容().getId());
                    bool4 = false;
                } else {
                    obcmeirong.setImageResource(R.mipmap.obcmeirong);
//                    list.remove(json.getT().getOBC美容().getId());
                    bool4 = true;
                }
                break;
            case R.id.ball_meixue:
                if (bool5) {
                    obcmeixue.setImageResource(R.mipmap.obcmeixue_select);
                    bool5 = false;
                } else {
                    obcmeixue.setImageResource(R.mipmap.obcmeixue);
                    bool5 = true;
                }
                break;
            //TODO  在职者化妆点击事件
            /**
             * zaizhizhe_huazhuang：原图
             */

            case R.id.zaizhizhe_huazhuang:
                if (flag1) {
                    huazhuang.setImageResource(R.mipmap.huazhuang_select);
                    flag1 = false;
                } else {
                    huazhuang.setImageResource(R.mipmap.huazhuang);
                    flag1 = true;
                }
                break;
            case R.id.zaizhizhe_meijia:
                if (flag2) {
                    meijia.setImageResource(R.mipmap.meijia_select);
                    flag2 = false;
                } else {
                    meijia.setImageResource(R.mipmap.meijia);
                    flag2 = true;
                }
                break;
            case R.id.zaizhizhe_meifa:
                if (flag3) {
                    meifa.setImageResource(R.mipmap.meifa_select);
                    flag3 = false;
                } else {
                    meifa.setImageResource(R.mipmap.meifa);
                    flag3 = true;
                }
                break;
            case R.id.zaizhizhe_meirong:
                if (flag4) {
                    meirong.setImageResource(R.mipmap.meirong_select);
                    flag4 = false;
                } else {
                    meirong.setImageResource(R.mipmap.meirong);
                    flag4 = true;
                }
                break;
            case R.id.zaizhizhe_meixue:
                if (flag5) {
                    meixue.setImageResource(R.mipmap.meixue_select);
                    flag5 = false;
                } else {
                    meixue.setImageResource(R.mipmap.meixue);
                    flag5 = true;
                }
                break;
            case R.id.tuanduijianshe:
                if (jy1) {
                    tuanduijianshe.setImageResource(R.mipmap.tuanduijianshe_select);
                    jy1 = false;
                } else {
                    tuanduijianshe.setImageResource(R.mipmap.tuanduijianshe);
                    jy1 = true;
                }
                break;
            case R.id.yejibeizeng:
                if (jy2) {
                    yejibeizeng.setImageResource(R.mipmap.yejibeizeng_select);
                    jy2 = false;
                } else {
                    yejibeizeng.setImageResource(R.mipmap.yejibeizeng);
                    jy2 = true;
                }
                break;
            case R.id.jingyingguanli:
                if (jy3) {
                    jingyingguanli.setImageResource(R.mipmap.jingyingguanli_select);
                    jy3 = false;
                } else {
                    jingyingguanli.setImageResource(R.mipmap.jingyingguanli);
                    jy3 = true;
                }
                break;
            case R.id.caiwuguanli:
                if (jy4) {
                    caiwuguanli.setImageResource(R.mipmap.caiwuguanli_select);
                    jy4 = false;
                } else {
                    caiwuguanli.setImageResource(R.mipmap.caiwuguanli);
                    jy4 = true;
                }
                break;
            case R.id.zibenyunzuo:
                if (jy5) {
                    zibenyunzuo.setImageResource(R.mipmap.zibenyunzuo_select);
                    jy5 = false;
                } else {
                    zibenyunzuo.setImageResource(R.mipmap.zibenyunzuo);
                    jy5 = true;
                }
                break;
            case R.id.qiyewenhua:
                if (jy6) {
                    qiyewenhua.setImageResource(R.mipmap.qiyewenhua_select);
                    jy6 = false;
                } else {
                    qiyewenhua.setImageResource(R.mipmap.qiyewenhua);
                    jy6 = true;
                }
                break;
            case R.id.kaiqi_aihaozhe_Btn:
                startActivity(new Intent(Guide_page.this, MainActivity.class));
                break;
        }
    }

    /**
     * 内部封装类
     */
    private void meiyezhe() {
        aihaozhe.setVisibility(View.GONE);
        meiyezhe.setVisibility(View.VISIBLE);
        obchuazhuang.setVisibility(View.GONE);
        obcmeijia.setVisibility(View.GONE);
        obcmeifa.setVisibility(View.GONE);
        obcmeirong.setVisibility(View.GONE);
        obcmeixue.setVisibility(View.GONE);
        huazhuang.setVisibility(View.GONE);
        meijia.setVisibility(View.GONE);
        meifa.setVisibility(View.GONE);
        meirong.setVisibility(View.GONE);
        meixue.setVisibility(View.GONE);
        tuanduijianshe.setVisibility(View.GONE);
        yejibeizeng.setVisibility(View.GONE);
        jingyingguanli.setVisibility(View.GONE);
        caiwuguanli.setVisibility(View.GONE);
        zibenyunzuo.setVisibility(View.GONE);
        qiyewenhua.setVisibility(View.GONE);
        meiyezhe.setEnabled(false);
        ball_chuxuezhe.setVisibility(View.VISIBLE);
        ball_jingyingzhe.setVisibility(View.VISIBLE);
        ball_zaizhizhe.setVisibility(View.VISIBLE);
        ObjectAnimator animator_up = ObjectAnimator.ofFloat(meiyezhe, "translationY", 0, -80);
        ObjectAnimator dwonY = ObjectAnimator.ofFloat(ball_zaizhizhe, "translationY", 0, 300f);

        ObjectAnimator dwon_leftY = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationY", 0, 300f);
        ObjectAnimator dwon_leftX = ObjectAnimator.ofFloat(ball_chuxuezhe, "translationX", 0, -200f);

        ObjectAnimator dwon_rightY = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationY", 0, 300f);
        ObjectAnimator dwon_rightX = ObjectAnimator.ofFloat(ball_jingyingzhe, "translationX", 0, 200f);
        AnimatorSet set2 = new AnimatorSet();
        set2.setDuration(2000);
        set2.play(dwonY).with(dwon_leftY).with(dwon_leftX).with(dwon_rightY).with(dwon_rightX).with(animator_up);
        set2.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(meiyezhe, "translationY", -80, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(aihaozhe, "translationY", -80, 0);
        ObjectAnimator animator = ObjectAnimator.ofFloat(aihaozhe, "translationX", 0, -200f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(meiyezhe, "translationX", 0, 200f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator1).with(animator2).with(animator3);
        set.setDuration(1000);
        set.start();
    }
}
