package io.weichao.fragment_demo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.weichao.fragment_demo.fragment.FourthFragment;
import io.weichao.fragment_demo.fragment.FirstFragment;
import io.weichao.fragment_demo.R;
import io.weichao.fragment_demo.fragment.SecondFragment;
import io.weichao.fragment_demo.fragment.ThirdFragment;
import io.weichao.fragment_demo.util.DateUtil;
import io.weichao.fragment_demo.util.FragmentUtil;

public class MainActivity extends AppCompatActivity {
    private Fragment mBeforeFragment;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        change2FirstFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        FirstFragment firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag("FirstFragment");
        if (firstFragment != null) {
            firstFragment.release();
        }

        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("SecondFragment");
        if (secondFragment != null) {
            secondFragment.release();
        }

        ThirdFragment thirdFragment = (ThirdFragment) getSupportFragmentManager().findFragmentByTag("ThirdFragment");
        if (thirdFragment != null) {
            thirdFragment.release();
        }

        FourthFragment fourthFragment = (FourthFragment) getSupportFragmentManager().findFragmentByTag("FourthFragment");
        if (fourthFragment != null) {
            fourthFragment.release();
        }
    }

    @Override
    public void onBackPressed() {
        if (mBeforeFragment == null) {
            finish();
        } else if (mFragment instanceof SecondFragment) {
            FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, mBeforeFragment);
            mFragment = mBeforeFragment;
            mBeforeFragment = null;
        } else if (mFragment instanceof FourthFragment) {
            if (mBeforeFragment instanceof FirstFragment) {
                change2FirstFragment();
            } else if (mBeforeFragment instanceof ThirdFragment) {
                change2ThirdFragment();
            }
        }
    }

    public void change2FirstFragment() {
        FirstFragment fragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag("FirstFragment");
        if (fragment == null) {
            fragment = FirstFragment.newInstance(this);
            Bundle bundle = new Bundle();
            bundle.putString("time", DateUtil.getCurrentTime());
            fragment.setArguments(bundle);
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "FirstFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
            fragment.update(DateUtil.getCurrentTime());
        }
        mBeforeFragment = null;
        mFragment = fragment;
    }

    public void change2SecondFragment() {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("SecondFragment");
        if (fragment == null) {
            fragment = SecondFragment.newInstance(this);
            Bundle bundle = new Bundle();
            bundle.putString("time", DateUtil.getCurrentTime());
            fragment.setArguments(bundle);
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "SecondFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
            fragment.update(DateUtil.getCurrentTime());
        }
        mBeforeFragment = mFragment;
        mFragment = fragment;
    }

    public void change2ThirdFragment() {
        ThirdFragment fragment = (ThirdFragment) getSupportFragmentManager().findFragmentByTag("ThirdFragment");
        if (fragment == null) {
            fragment = ThirdFragment.newInstance(this);
            Bundle bundle = new Bundle();
            bundle.putString("time", DateUtil.getCurrentTime());
            fragment.setArguments(bundle);
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "ThirdFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
            fragment.update(DateUtil.getCurrentTime());
        }
        mBeforeFragment = null;
        mFragment = fragment;
    }

    public void change2FourthFragment() {
        FourthFragment fragment = (FourthFragment) getSupportFragmentManager().findFragmentByTag("FourthFragment");
        if (fragment == null) {
            fragment = FourthFragment.newInstance(this);
            Bundle bundle = new Bundle();
            bundle.putString("time", DateUtil.getCurrentTime());
            fragment.setArguments(bundle);
            FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fragment, mFragment, fragment, "FourthFragment");
        } else {
            if (mFragment != fragment) {
                FragmentUtil.showFragment(getSupportFragmentManager(), mFragment, fragment);
            }
            fragment.update(DateUtil.getCurrentTime());
        }
        mBeforeFragment = mFragment;
        mFragment = fragment;
    }
}
