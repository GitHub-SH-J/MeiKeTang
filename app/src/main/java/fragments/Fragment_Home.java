package fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.best.meiketang.R;

/**
 * Created by best on 2017/12/4.
 */

public class Fragment_Home extends Fragment {
    private Fragment[] fragments = {new Fragment_recommend(), new Fragment_selete_class(), new Fragment_search()};
    private int[] id_all = {R.id.shouye_tuijian, R.id.shouye_xuanke, R.id.shouye_sousuo};
    private RadioButton[] buttons = new RadioButton[id_all.length];
    private FragmentManager manager;
    private RadioGroup mRadioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        manager = getChildFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (!fragments[0].isAdded()) {
            ft.add(R.id.shouye_Relativelayout, fragments[0]);
            ft.commit();
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (RadioButton) view.findViewById(id_all[i]);
        }
        buttons[0].setTextColor(Color.parseColor("#f57fd7"));

        mRadioGroup = (RadioGroup) view.findViewById(R.id.shouye_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (i) {
                    case R.id.shouye_tuijian:
                        ft.replace(R.id.shouye_Relativelayout, fragments[0]);
                        changColor(0);
                        break;
                    case R.id.shouye_xuanke:
                        ft.replace(R.id.shouye_Relativelayout, fragments[1]);
                        changColor(1);
                        break;
                    case R.id.shouye_sousuo:
                        ft.replace(R.id.shouye_Relativelayout, fragments[2]);
                        changColor(2);
                        break;
                }
                ft.commit();
            }
        });

        return view;
    }

    private void changColor(int i) {
        for (int j = 0; j < buttons.length; j++) {
            if (j == i) {
                buttons[j].setTextColor(Color.parseColor("#f57fd7"));
            } else {
                buttons[j].setTextColor(Color.BLACK);
            }
        }
    }
}
