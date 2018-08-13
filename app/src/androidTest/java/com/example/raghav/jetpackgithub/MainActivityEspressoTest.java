package com.example.raghav.jetpackgithub;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.raghav.jetpackgithub.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork() {
        onView(withId(R.id.githubUserIdInput)).perform(typeText("octocat"), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).perform(click());

        onView(withId(R.id.repos_list_view)).perform(swipeUp());
        onView(withId(R.id.repos_list_view)).perform(swipeDown());
        onView(withId(R.id.repos_list_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
