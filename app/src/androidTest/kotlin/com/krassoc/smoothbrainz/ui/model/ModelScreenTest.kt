package com.krassoc.smoothbrainz.ui.model

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.krassoc.smoothbrainz.ui.model.ModelScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for [com.krassoc.smoothbrainz.ui.model.ModelScreen].
 */
@RunWith(AndroidJUnit4::class)
class ModelScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
 //       composeTestRule.setContent {
 //           ModelScreen(FAKE_DATA, onSave = {})
 //       }
    }

    @Test
    fun firstItem_exists() {
//        composeTestRule.onNodeWithText(FAKE_DATA.first()).assertExists().performClick()
    }
}

private val FAKE_DATA = listOf("Compose", "Room", "Kotlin")
