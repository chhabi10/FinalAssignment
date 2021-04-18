package com.chhabi.finalassignment

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.chhabi.finalassignment.activities.ui.RegisterActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4



@LargeTest
@RunWith(JUnit4::class)
class Logintesting {
    @get:Rule
    val testRule = ActivityScenarioRule(RegisterActivity::class.java)

    @Test
    fun testLoginUI() {
        onView(withId(R.id.etusername))
                .perform(typeText("chhabi"))
        onView(withId(R.id.etpassword))
                .perform(typeText("cb123"))

        closeSoftKeyboard()
        onView(withId(R.id.btnlogin))
                .perform(click())

        onView(withId(R.id.etfname))
                .check(matches(withText("welcome")))

    }
}








