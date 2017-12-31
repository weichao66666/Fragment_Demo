package io.weichao.fragment_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.weichao.fragment_demo.R;
import io.weichao.fragment_demo.activity.MainActivity;

/**
 * Created by WEI CHAO on 2017/12/31.
 */
public class FirstFragment extends Fragment {
    private static final String TAG = "FirstFragment";

    private static MainActivity mMainActivity;

    private TextView mTimeTv;
    private Button mChange2SecondFragmentBtn;
    private Button mChange2ThirdFragmentBtn;
    private Button mChange2FourthFragmentBtn;

    private String mTime;

    public static FirstFragment newInstance(MainActivity view) {
        mMainActivity = view;
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            mTime = arguments.getString("time");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_first, null);
        mTimeTv = rootView.findViewById(R.id.tv_time);
        mChange2SecondFragmentBtn = rootView.findViewById(R.id.btn_change2SecondFragment);
        mChange2ThirdFragmentBtn = rootView.findViewById(R.id.btn_change2ThirdFragment);
        mChange2FourthFragmentBtn = rootView.findViewById(R.id.btn_change2FourthFragment);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTimeTv.setText(TAG + " 时间：" + mTime);
        mChange2SecondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivity != null) {
                    mMainActivity.change2SecondFragment();
                } else {
                    Log.e(TAG, "mMainActivity == null");
                }
            }
        });
        mChange2ThirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivity != null) {
                    mMainActivity.change2ThirdFragment();
                } else {
                    Log.e(TAG, "mMainActivity == null");
                }
            }
        });
        mChange2FourthFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMainActivity != null) {
                    mMainActivity.change2FourthFragment();
                } else {
                    Log.e(TAG, "mMainActivity == null");
                }
            }
        });
    }

    public void update(String time) {
        mTimeTv.setText(TAG + " 时间：" + time);
    }

    public void release() {
        mMainActivity = null;
    }
}
