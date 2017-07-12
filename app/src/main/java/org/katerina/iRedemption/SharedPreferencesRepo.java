package org.katerina.iRedemption;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Katerina Draenkova on 12.07.2017.
 */

public class SharedPreferencesRepo {

    private static SharedPreferencesRepo mSharedPreferencesRepo;

    public static SharedPreferencesRepo getInstance(final Context context) {
        if (mSharedPreferencesRepo == null) {
            mSharedPreferencesRepo = new SharedPreferencesRepo(context);
        }
        return mSharedPreferencesRepo;
    }

    private static final String STORAGE_FILENAME = "shared_preferences_repo";
    private static final String LICENSE_AGREEMENT = "license_agreement";

    private final SharedPreferences mSharedPreferences;

    private SharedPreferencesRepo(final Context context) {
        mSharedPreferences = context.getSharedPreferences(STORAGE_FILENAME, Context.MODE_PRIVATE);
    }

    public void setLicenseAgreement(final boolean agree) {
        mSharedPreferences.edit().putBoolean(LICENSE_AGREEMENT, agree).apply();
    }

    public boolean isLicenseAgreement() {
        return mSharedPreferences.getBoolean(LICENSE_AGREEMENT, false);
    }


}
