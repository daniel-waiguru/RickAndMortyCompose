package tech.danielwaiguru.data.models.response

import tech.danielwaiguru.data.models.CharacterDto

data class CharacterResponse(
    val results: List<CharacterDto>
)