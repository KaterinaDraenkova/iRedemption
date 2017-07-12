package org.katerina.iRedemption;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Katerina Draenkova on 12.07.2017.
 */

public class AnswersActivity extends AppCompatActivity {

    @NonNull
    public static Intent createIntent(final Context context) {
        return new Intent(context, AnswersActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        ButterKnife.bind(this);
    }
}
