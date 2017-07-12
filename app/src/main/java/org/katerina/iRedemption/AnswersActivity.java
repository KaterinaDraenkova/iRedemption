package org.katerina.iRedemption;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Katerina Draenkova on 12.07.2017.
 */

class AnswersActivity extends AppCompatActivity {

    @NonNull
    public static Intent createIntent(final Context context) {
        return new Intent(context, AnswersActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, TaskFirstFragment.newInstance(), TaskFirstFragment.TAG)
                    .commit();
        }

    }
}
