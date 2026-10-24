package com.krassoc.smoothbrainz.util.network.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

import com.krassoc.smoothbrainz.model.repo.INetworkMonitor
import com.krassoc.smoothbrainz.util.network.ConnectivityManagerNetworkMonitor

val dispatchersKoinModule = module {
    single<CoroutineDispatcher> { Dispatchers.IO }
    single<CoroutineDispatcher>(named("default")) { Dispatchers.Default }
}
val coroutineScopesKoinModule = module {
    single<CoroutineScope> { CoroutineScope(SupervisorJob() + get<CoroutineDispatcher>(named("default"))) }
}

val networkMonitorModule = module {
    singleOf(::ConnectivityManagerNetworkMonitor) bind INetworkMonitor::class
}

val networkKoinModule = module {
    includes(dispatchersKoinModule)
    includes(coroutineScopesKoinModule)
    includes(networkMonitorModule)
}
