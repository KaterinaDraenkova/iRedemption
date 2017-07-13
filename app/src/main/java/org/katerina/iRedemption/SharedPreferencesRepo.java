package org.katerina.iRedemption;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
    private static final String GIVEN_ANSWERS = "given_answers";
    private static final String ATTEMPT_COUNT = "attempt_count";

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

    @NonNull
    public String getAnswers() {
        return mSharedPreferences.getString(GIVEN_ANSWERS, "");
    }

    public void setAnswer(@NonNull final String newChar) {
        mSharedPreferences.edit().putString(GIVEN_ANSWERS, getAnswers() + newChar).apply();
    }

    public int getAttemptCount() {
        return mSharedPreferences.getInt(ATTEMPT_COUNT, 0);
    }

    public void setErrorAgain() {
        mSharedPreferences.edit().putInt(ATTEMPT_COUNT, getAttemptCount() + 1).apply();
    }

    public void clearAllResults() {
        setLicenseAgreement(false);
        mSharedPreferences.edit().putString(GIVEN_ANSWERS, "").apply();
        mSharedPreferences.edit().putInt(ATTEMPT_COUNT, 0).apply();
    }
}
