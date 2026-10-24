package com.krassoc.smoothbrainz.ui.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

import com.krassoc.smoothbrainz.ui.feature1.impl.feature1Module
import com.krassoc.smoothbrainz.ui.featuresettings.impl.settingsModule
import com.krassoc.smoothbrainz.ui.featuresettings.impl.SettingsViewModel
import com.krassoc.smoothbrainz.ui.MainActivityViewModel

val featureModules = module {
    includes(feature1Module, settingsModule)
}
val viewModelModules = module {
    viewModelOf(::MainActivityViewModel)
}