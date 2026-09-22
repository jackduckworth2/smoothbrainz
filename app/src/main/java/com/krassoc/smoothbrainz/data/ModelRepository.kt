package com.krassoc.smoothbrainz.data

import com.krassoc.smoothbrainz.data.di.fakeModels
import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface ModelRepository {
    val models: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultModelRepository @Inject constructor(
) : ModelRepository {

    override val models: Flow<List<String>> = flowOf(fakeModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}
