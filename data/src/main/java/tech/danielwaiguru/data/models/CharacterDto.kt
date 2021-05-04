package tech.danielwaiguru.data.models

import com.squareup.moshi.Json

data class CharacterDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "gender") val gender: String,
    @field:Json(name = "origin") val image: String,
    @field:Json(name = "created") val created: String
    )