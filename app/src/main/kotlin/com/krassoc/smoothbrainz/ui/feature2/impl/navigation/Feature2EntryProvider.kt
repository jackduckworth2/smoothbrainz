package com.krassoc.smoothbrainz.ui.feature2.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.krassoc.smoothbrainz.ui.navigation.Navigator
import com.krassoc.smoothbrainz.ui.feature1.impl.Feature1Screen
import com.krassoc.smoothbrainz.ui.feature2.api.Feature2NavKey
import com.krassoc.smoothbrainz.ui.feature2.api.navigateToTopic

fun EntryProviderScope<NavKey>.feature2Entry(navigator: Navigator) {
    entry<Feature2NavKey> {
        Feature1Screen(
            onTopicClick = navigator::navigateToTopic,
            )
    }
}
