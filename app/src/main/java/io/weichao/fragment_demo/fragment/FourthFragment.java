package io.weichao.fragment_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.weichao.fragment_demo.R;
import io.weichao.fragment_demo.activity.MainActivity;

/**
 * Created by WEI CHAO on 2017/12/31.
 */
public class FourthFragment extends Fragment {
    private static final String TAG = "FourthFragment";

    private static MainActivity mMainActivity;

    private TextView mTimeTv;

    private String mTime;

    public static FourthFragment newInstance(MainActivity view) {
        mMainActivity = view;
        return new FourthFragment();
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
        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_fourth, null);
        mTimeTv = rootView.findViewById(R.id.tv_time);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTimeTv.setText(TAG + " 时间：" + mTime);
    }

    public void update(String time) {
        mTimeTv.setText(TAG + " 时间：" + time);
    }

    public void release() {
        mMainActivity = null;
    }
}
