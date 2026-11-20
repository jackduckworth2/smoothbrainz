package com.krassoc.smoothbrainz.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

import com.krassoc.smoothbrainz.model.repo.IUserDataRepository
import com.krassoc.smoothbrainz.data.repository.UserDataRepositoryImpl
import com.krassoc.smoothbrainz.data.repository.ListenbrainzUserSettings
import com.krassoc.smoothbrainz.data.services.local.SharedPreferencesService
import com.krassoc.smoothbrainz.data.services.remote.ListenBrainzAPI.ListenBrainzAPI
import com.krassoc.smoothbrainz.model.repo.IListenbrainzUserSettings
import com.krassoc.smoothbrainz.model.services.IListenBrainzAPI
import com.krassoc.smoothbrainz.model.services.IUserPreferencesService

val dataKoinModule = module {
    singleOf(::UserDataRepositoryImpl) bind IUserDataRepository::class
    singleOf(::SharedPreferencesService) bind IUserPreferencesService::class
    singleOf(::ListenbrainzUserSettings) bind IListenbrainzUserSettings::class
    singleOf(::ListenBrainzAPI) bind IListenBrainzAPI::class
}