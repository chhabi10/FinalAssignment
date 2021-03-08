package com.chhabi.finalassignment

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.chhabi.finalassignment.activities.ui.UI.LoginActivity
import com.chhabi.finalassignment.activities.ui.UI.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(JUnit4::class)
class LoginTesting {
    @get:Rule
    val  testRule= ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLogin(){
        onView(withId(R.id.etusername))
                .perform(typeText("rift"))
        Thread.sleep(1000)

        onView(withId(R.id.etpassword))
                .perform(typeText("right"))
        Thread.sleep(1000)
        closeSoftKeyboard()

        onView(withId(R.id.btnlogin))
                .perform((click()))
        Thread.sleep(2000)

        onView(withId(R.id.dashboard))
                .check(matches(isDisplayed()))



    }
}