package com.krassoc.smoothbrainz.ui.feature2.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

import com.krassoc.smoothbrainz.ui.navigation.Navigator

@Serializable
object Feature2NavKey : NavKey

fun Navigator.navigateToTopic(
    topicId: String,
) {
    //navigate(Feature2NavKey())
    navigate(Feature2NavKey)
}
