package com.example.studentverse

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.studentverse.activity.ui.SignupActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class RegisterUIInstrumentedTesting {

    @get:Rule
    val testRule = ActivityScenarioRule(SignupActivity::class.java)

    @Test
    fun checkSignup() {
        Espresso.onView(ViewMatchers.withId(R.id.etfname))
            .perform(ViewActions.typeText("Zeref"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etlname))
            .perform(ViewActions.typeText("Dragneel"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etmobile))
            .perform(ViewActions.typeText("9876543210"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etaddress))
            .perform(ViewActions.typeText("Magnelium"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etemail))
            .perform(ViewActions.typeText("zeref123@gmail.com"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etpassword))
            .perform(ViewActions.typeText("12345"))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.etrepassword))
            .perform(ViewActions.typeText("12345"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.btnsignup))
            .perform(ViewActions.click())

        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.btnlogin))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}