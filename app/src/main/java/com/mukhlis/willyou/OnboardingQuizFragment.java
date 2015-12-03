package com.mukhlis.willyou;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by yahyamukhlis on 9/29/15.
 */
public class OnboardingQuizFragment extends Fragment {

    private View mRootView;

    private Button btnNo;

    private Button btnYes;

    private static final String PHONE_NUMBER = "08986858699";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.onboarding_quiz, container, false);
            btnNo = (Button) mRootView.findViewById(R.id.btn_no);
            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendSms(PHONE_NUMBER);
                }
            });
            btnYes = (Button) mRootView.findViewById(R.id.btn_yes);
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callNumber(PHONE_NUMBER);
                }
            });
        }

        return mRootView;

    }

    private void callNumber(String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
    }

    private void sendSms(String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:" + Uri.encode(phoneNumber)));
            smsIntent.putExtra("sms_body", "Thank's for loving me.... I'm sorry....");
            startActivity(smsIntent);
        }
    }
}
