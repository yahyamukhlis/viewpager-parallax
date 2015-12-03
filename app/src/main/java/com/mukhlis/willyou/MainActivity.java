package com.mukhlis.willyou;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahyamukhlis on 9/29/15.
 */
public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private SmartTabLayout indicator;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (SmartTabLayout)findViewById(R.id.indicator);

        initFragments();

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new CustomPageTransformer());
        indicator.setViewPager(pager);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new OnboardingFightingFragment());
        mFragments.add(new OnboardingTogetherFragment());
        mFragments.add(new OnboardingCommitmentFragment());
        mFragments.add(new OnboardingQuizFragment());
    }

}
