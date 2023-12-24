package com.example.dashboard

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class MainActivityKtTest {
    @get:Rule()
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testScheduleTextExists() {
        composeRule.onNodeWithText("Расписание").assertExists()
    }

    @Test
    fun testScheduleTextDisplayed() {
        composeRule.onNodeWithText("Расписание").assertIsDisplayed()
    }

    @Test
    fun testScheduleTextEnabled() {
        composeRule.onNodeWithText("Расписание").assertIsEnabled()
    }
}