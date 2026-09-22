package com.krassoc.smoothbrainz.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.krassoc.smoothbrainz.data.ModelRepository
import com.krassoc.smoothbrainz.data.DefaultModelRepository
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsMyModelRepository(
        myModelRepository: DefaultModelRepository
    ): ModelRepository
}

class FakeModelRepository @Inject constructor() : ModelRepository {
    override val models: Flow<List<String>> = flowOf(fakeModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeModels = listOf("One", "Two", "Three")
