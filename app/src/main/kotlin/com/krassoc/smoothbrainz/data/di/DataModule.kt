package com.krassoc.smoothbrainz.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

import com.krassoc.smoothbrainz.model.repo.IUserDataRepository
import com.krassoc.smoothbrainz.data.repository.UserDataRepositoryImpl
import com.krassoc.smoothbrainz.data.services.local.SharedPreferencesService
import com.krassoc.smoothbrainz.model.services.ISharedPreferencesService

val dataKoinModule = module {
    singleOf(::UserDataRepositoryImpl) bind IUserDataRepository::class
    singleOf(::SharedPreferencesService) bind ISharedPreferencesService::class
}