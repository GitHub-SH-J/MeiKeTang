package com.example.best.meiketang;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fragments.Fragment_Home;
import fragments.Fragment_MyClass;
import fragments.Fragment_Personal;

public class MainActivity extends AppCompatActivity {
    private Fragment[] fragments = {new Fragment_Home(), new Fragment_Personal(), new Fragment_MyClass()};
    private int[] id_btn = {R.id.mRb_Home, R.id.mRb_MyClass, R.id.mRb_Personal};
    private RadioButton[] buttons = new RadioButton[id_btn.length];
    private RadioGroup mRadioGroup;
    private FragmentManager manager;
    //测试

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.mRelativeLayout, fragments[0]);
        fragmentTransaction.commit();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (RadioButton) findViewById(id_btn[i]);
        }
        buttons[0].setSelected(true);
        buttons[0].setTextColor(Color.parseColor("#f57fd7"));
        //fragment切换
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (i) {
                    case R.id.mRb_Home:
                        ft.replace(R.id.mRelativeLayout, fragments[0]);
                        changColor(0);
                        break;
                    case R.id.mRb_MyClass:
                        ft.replace(R.id.mRelativeLayout, fragments[1]);
                        changColor(1);
                        break;
                    case R.id.mRb_Personal:
                        ft.replace(R.id.mRelativeLayout, fragments[2]);
                        changColor(2);
                        break;
                }
                ft.commit();
            }
        });

    }

    private void changColor(int i) {
        for (int j = 0; j < buttons.length; j++) {
            if (j == i) {
                buttons[j].setSelected(true);
                buttons[j].setTextColor(Color.parseColor("#f57fd7"));
            } else {
                buttons[j].setSelected(false);
                buttons[j].setTextColor(Color.BLACK);
            }
        }
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
    }
}
