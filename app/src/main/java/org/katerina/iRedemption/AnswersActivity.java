package org.katerina.iRedemption;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Katerina Draenkova on 12.07.2017.
 */

public class AnswersActivity extends AppCompatActivity {

    @BindView(R.id.task_number)
    TextView mTaskNumber;
    @BindView(R.id.answer_edit_text)
    EditText mAnswerEditText;

    private static final String RIGHT_ANSWERS = "idegwdn";
    private static final int AVAILABLE_ATTEMPT_COUNT = 3;
    private String mAnswers;
    private int mAttemptCount;
    final SharedPreferencesRepo mSharedPreferencesRepo = SharedPreferencesRepo.getInstance(this);

    @NonNull
    public static Intent createIntent(final Context context) {
        return new Intent(context, AnswersActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        ButterKnife.bind(this);

        initAnswers();
        initTaskNumber();
        initAttemptCount();
    }

    private void initTaskNumber() {
        final String taskNumber = String.format(getString(R.string.task_number), mAnswers.length() + 1);
        mTaskNumber.setText(taskNumber);
    }

    private void initAttemptCount() {
        mAttemptCount = mSharedPreferencesRepo.getAttemptCount();
    }

    private void initAnswers() {
        mAnswers = mSharedPreferencesRepo.getAnswers();
    }

    @OnClick(R.id.continue_button)
    public void onFabClick() {
        final String answer = mAnswerEditText.getText().toString().toLowerCase();
        if (answer.charAt(0) == RIGHT_ANSWERS.charAt(mAnswers.length())) {
            mSharedPreferencesRepo.setAnswer(answer);
            initAnswers();

            if (mAnswers.length() == RIGHT_ANSWERS.length()) {
                final Intent intent = FinishActivity.createIntent(this);
                startActivity(intent);
                finish();
            }
            
            initTaskNumber();
            mAnswerEditText.setText("");
        } else {
            mSharedPreferencesRepo.setErrorAgain();
            initAttemptCount();
            mAnswerEditText.setError("Введён неверный ответ. Осталось попыток: " + (AVAILABLE_ATTEMPT_COUNT - mAttemptCount));

            if (mAttemptCount == AVAILABLE_ATTEMPT_COUNT) {
                mSharedPreferencesRepo.clearAllResults();

                final Intent intent = SadActivity.createIntent(this);
                startActivity(intent);
                finish();
            }
        }
    }
}
