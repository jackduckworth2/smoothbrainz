package com.krassoc.smoothbrainz.ui.featuresettings.impl

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule = module {
    viewModelOf(::SettingsViewModel)
}