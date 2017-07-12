package org.katerina.iRedemption;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Katerina Draenkova on 12.07.2017.
 */

public class AgreementActivity extends Activity {

    @NonNull
    public static Intent createIntent(final Context context) {
        return new Intent(context, AgreementActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.agree)
    public void onAgreeClick() {
        final SharedPreferencesRepo sharedPreferencesRepo = SharedPreferencesRepo.getInstance(this);
        sharedPreferencesRepo.setLicenseAgreement(true);

        final Intent intent = AnswersActivity.createIntent(this);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.disagree)
    public void onDisagreeClick() {
        finish();
    }
}
