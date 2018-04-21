package com.example.ben.form;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivity2Test {

    @Rule
    public ActivityTestRule<MainActivity2> activityTestRule
            = new ActivityTestRule<MainActivity2>(MainActivity2.class){
        @Override
        protected Intent getActivityIntent() {
            Intent testIntent = new Intent();
            testIntent.putExtra(Constants.KEY_USER, "iroenu");
            return testIntent;
        }
    };

    @Test
    public void setsRightMessageBasedOnIntentExtra() {
        onView(withId(R.id.textView))
                .check(matches(withText("Thanks for signing up, iroenu!")));
    }

}