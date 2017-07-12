package org.katerina.iRedemption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent;
        final SharedPreferencesRepo sharedPreferencesRepo = SharedPreferencesRepo.getInstance(this);
        final boolean agree = sharedPreferencesRepo.isLicenseAgreement();

        if (agree) {
            intent = AnswersActivity.createIntent(this);
        } else {
            intent = AgreementActivity.createIntent(this);
        }
        startActivity(intent);
        finish();
    }
}
