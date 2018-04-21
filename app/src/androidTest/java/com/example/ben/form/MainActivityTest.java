package com.example.ben.form;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canGoToSecondActivityWithMessage() {
        // Test the name field.
        onView(withId(R.id.name)).perform(typeText("Wenbin"));

        // Test the username field.
        onView(withId(R.id.user)).perform(typeText("iroenu"));

        // Test the email field.
        onView(withId(R.id.email)).perform(typeText("weguan@gmail.com"));

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.message)).check(matches(withText("Thanks for signing up, iroenu!")));
    }


}