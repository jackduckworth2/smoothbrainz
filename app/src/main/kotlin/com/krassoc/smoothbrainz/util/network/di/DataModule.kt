package com.krassoc.smoothbrainz.util.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.krassoc.smoothbrainz.model.repo.INetworkMonitor
import com.krassoc.smoothbrainz.util.network.ConnectivityManagerNetworkMonitorImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitorImpl,
    ): INetworkMonitor

}

