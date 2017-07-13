package org.katerina.iRedemption;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;


/**
 * Created by Katerina Draenkova on 13.07.2017.
 */

public class FinishActivity extends Activity {

    @NonNull
    public static Intent createIntent(final Context context) {
        return new Intent(context, FinishActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }
}
