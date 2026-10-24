package com.krassoc.smoothbrainz.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

import com.krassoc.smoothbrainz.model.repo.IUserDataRepository
import com.krassoc.smoothbrainz.data.repository.OfflineFirstUserDataRepositoryImpl
import com.krassoc.smoothbrainz.data.services.local.SharedPreferencesService

val dataKoinModule = module {
    singleOf(::OfflineFirstUserDataRepositoryImpl) bind IUserDataRepository::class
    singleOf(::SharedPreferencesService)
}