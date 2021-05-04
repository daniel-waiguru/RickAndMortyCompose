package tech.danielwaiguru.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import tech.danielwaiguru.data.models.CharacterDto
import tech.danielwaiguru.data.models.response.CharacterResponse

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): CharacterDto
}