package com.krassoc.smoothbrainz.ui.feature1.impl

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val feature1Module = module {
    viewModelOf(::Feature1ViewModel)
}