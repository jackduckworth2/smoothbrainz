package com.krassoc.smoothbrainz.ui.feature3.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.krassoc.smoothbrainz.ui.navigation.Navigator
import com.krassoc.smoothbrainz.ui.feature1.impl.Feature1Screen
import com.krassoc.smoothbrainz.ui.feature2.api.navigateToTopic
import com.krassoc.smoothbrainz.ui.feature3.api.Feature3NavKey

fun EntryProviderScope<NavKey>.feature3Entry(navigator: Navigator) {
    entry<Feature3NavKey> {
        Feature1Screen(
            onTopicClick = navigator::navigateToTopic,
            )
    }
}
