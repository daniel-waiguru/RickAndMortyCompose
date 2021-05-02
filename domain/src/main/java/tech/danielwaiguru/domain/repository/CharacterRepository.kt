package tech.danielwaiguru.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.danielwaiguru.domain.models.Character

interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>>
    suspend fun getCharacterDetails(id: Int): Flow<Character>
}