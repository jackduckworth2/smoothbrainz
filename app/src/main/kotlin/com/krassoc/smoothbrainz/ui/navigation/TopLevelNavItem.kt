package com.krassoc.smoothbrainz.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

import com.krassoc.smoothbrainz.ui.icon.MyIcons
import com.krassoc.smoothbrainz.R
import com.krassoc.smoothbrainz.ui.feature1.api.Feature1NavKey
import com.krassoc.smoothbrainz.ui.feature2.api.Feature2NavKey
import com.krassoc.smoothbrainz.ui.feature3.api.Feature3NavKey

/**
 * Type for the top level navigation items in the application. Contains UI information about the
 * current route that is used in the top app bar and common navigation UI.
 *
 * @param selectedIcon The icon to be displayed in the navigation UI when this destination is
 * selected.
 * @param unselectedIcon The icon to be displayed in the navigation UI when this destination is
 * not selected.
 * @param iconTextId Text that to be displayed in the navigation UI.
 * @param titleTextId Text that is displayed on the top app bar.
 */
data class TopLevelNavItem(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
)

val FEATURE_1 = TopLevelNavItem(
    selectedIcon   = MyIcons.Upcoming,
    unselectedIcon = MyIcons.UpcomingBorder,
    iconTextId     = R.string.feature1_api_title,
    titleTextId    = R.string.app_name,
)

val FEATURE_2 = TopLevelNavItem(
    selectedIcon   = MyIcons.Bookmarks,
    unselectedIcon = MyIcons.BookmarksBorder,
    iconTextId     = R.string.feature_bookmarks_api_title,
    titleTextId    = R.string.feature_bookmarks_api_title,
)

val FEATURE_3 = TopLevelNavItem(
    selectedIcon   = MyIcons.Grid3x3,
    unselectedIcon = MyIcons.Grid3x3,
    iconTextId     = R.string.feature_search_api_interests,
    titleTextId    = R.string.feature_search_api_interests,
)

val TOP_LEVEL_NAV_ITEMS = mapOf(
    Feature1NavKey to FEATURE_1,
    Feature2NavKey to FEATURE_2,
    Feature3NavKey to FEATURE_3,
)
