package com.mukhlis.willyou;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by yahyamukhlis on 9/29/15.
 */
public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private SmartTabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (SmartTabLayout)findViewById(R.id.indicator);

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0 : return new OnboardingFightingFragment();
                    case 1 : return new OnboardingTogetherFragment();
                    case 2 : return new OnboardingCommitmentFragment();
                    case 3 : return new OnboardingQuizFragment();
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };

        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new CustomPageTransformer());
        indicator.setViewPager(pager);
    }

}
