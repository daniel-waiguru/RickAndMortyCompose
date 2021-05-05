package tech.danielwaiguru.data.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tech.danielwaiguru.data.api.ApiService
import tech.danielwaiguru.data.mappers.CharacterMapper
import tech.danielwaiguru.domain.models.Character
import tech.danielwaiguru.domain.repository.CharacterRepository
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val apiService: ApiService, private val mapper: CharacterMapper): CharacterRepository {
    override suspend fun getCharacters(): Flow<List<Character>> {
        return flow {
            Log.d("API", apiService.getCharacters().results.toString())
            val response = apiService.getCharacters().results.map {
                mapper.characterDtoToDomain(it)
            }
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getCharacterDetails(id: Int): Flow<Character> {
        return flow {
            val response = apiService.getCharacterDetails(id)
            emit(mapper.characterDtoToDomain(response))
        }.flowOn(Dispatchers.IO)
    }
}