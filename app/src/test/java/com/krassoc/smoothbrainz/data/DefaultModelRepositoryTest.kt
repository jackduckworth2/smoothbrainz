package com.krassoc.smoothbrainz.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.krassoc.smoothbrainz.data.local.database.Model
import com.krassoc.smoothbrainz.data.local.database.ModelDao

/**
 * Unit tests for [DefaultModelRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultModelRepositoryTest {

    @Test
    fun models_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultModelRepository(FakeModelDao())

        repository.add("Repository")

        assertEquals(repository.models.first().size, 1)
    }

}

private class FakeModelDao : ModelDao {

    private val data = mutableListOf<Model>()

    override fun getModels(): Flow<List<Model>> = flow {
        emit(data)
    }

    override suspend fun insertModel(item: Model) {
        data.add(0, item)
    }
}
