package com.mukhlis.willyou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yahyamukhlis on 9/29/15.
 */
public class OnboardingCommitmentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        return inflater.inflate(R.layout.onboarding_commitment, container, false);

    }
}
