package com.mukhlis.willyou;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yahyamukhlis on 11/3/15.
 */
public class CustomPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
//            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView description = (TextView) view.findViewById(R.id.description);

            if (title != null) {
                title.setTranslationX((position) * (pageWidth / 1));
            }

            if (description != null) {
                description.setTranslationX((-position) * (pageWidth * 2));
            }
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);
        }
    }
}
