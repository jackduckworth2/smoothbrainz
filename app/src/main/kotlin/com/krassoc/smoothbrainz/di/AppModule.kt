package com.krassoc.smoothbrainz.di

import org.koin.dsl.module

import com.krassoc.smoothbrainz.data.di.dataKoinModule
import com.krassoc.smoothbrainz.ui.di.featureModules
import com.krassoc.smoothbrainz.ui.di.viewModelModules
import com.krassoc.smoothbrainz.util.network.di.networkKoinModule
val appModule = module {
    includes(dataKoinModule, featureModules, viewModelModules, networkKoinModule)
}