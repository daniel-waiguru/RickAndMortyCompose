package tech.danielwaiguru.data.repository

import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Character
import tech.danielwaiguru.domain.repository.CharacterRepository

class CharacterRepositoryImpl: CharacterRepository {
    override suspend fun getCharacters(): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetails(): Flow<Character> {
        TODO("Not yet implemented")
    }
}