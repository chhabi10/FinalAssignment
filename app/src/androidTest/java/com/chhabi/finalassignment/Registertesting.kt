package com.chhabi.finalassignment

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
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
class Registertesting {
    @get:Rule
    val testRule= ActivityScenarioRule(RegisterActivity::class.java)

    @Test
    fun testRegisterUI(){
        Espresso.onView(ViewMatchers.withId(R.id.etfname))
            .perform(ViewActions.typeText("chhabi"))

        Espresso.onView(ViewMatchers.withId(R.id.etlname))
            .perform(ViewActions.typeText("bista"))



        Espresso.onView(ViewMatchers.withId(R.id.etusername))
            .perform(ViewActions.typeText("chhabi"))

        Espresso.onView(ViewMatchers.withId(R.id.etpassword))
            .perform(ViewActions.typeText("1234"))



        Espresso.onView(ViewMatchers.withId(R.id.btnsign))
            .perform(ViewActions.click())
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etusername))
            .check(matches(withText("welcome back")))



    }
}
