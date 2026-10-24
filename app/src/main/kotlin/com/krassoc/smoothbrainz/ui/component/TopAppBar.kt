@file:OptIn(ExperimentalMaterial3Api::class)

package com.krassoc.smoothbrainz.ui.component

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import com.krassoc.smoothbrainz.ui.icon.MyIcons
import com.krassoc.smoothbrainz.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    @StringRes titleRes: Int,
    @DrawableRes navigationIcon: Int,
    navigationIconContentDescription: String,
    @DrawableRes actionIcon: Int,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    painter = painterResource(navigationIcon),
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = painterResource(actionIcon),
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("TopAppBar"),
    )
}

@Preview("Top App Bar")
@Composable
private fun TopAppBarPreview() {
    MyApplicationTheme {
        TopAppBar(
            titleRes = android.R.string.untitled,
            navigationIcon = MyIcons.Search,
            navigationIconContentDescription = "Navigation icon",
            actionIcon = MyIcons.MoreVert,
            actionIconContentDescription = "Action icon",
        )
    }
}
