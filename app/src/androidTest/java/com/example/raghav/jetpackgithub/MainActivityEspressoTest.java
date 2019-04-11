package com.example.raghav.jetpackgithub;

import com.example.raghav.jetpackgithub.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork() {
        onView(withId(R.id.github_user_id_input)).perform(typeText("octocat"), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).perform(click());

        onView(withId(R.id.repos_list_view)).perform(swipeUp());
        onView(withId(R.id.repos_list_view)).perform(swipeDown());
        onView(withId(R.id.repos_list_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
