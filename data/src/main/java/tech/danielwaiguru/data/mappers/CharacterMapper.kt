package tech.danielwaiguru.data.mappers

import tech.danielwaiguru.data.models.CharacterDto
import tech.danielwaiguru.domain.models.Character

class CharacterMapper {
    fun characterDtoToDomain(characterDto: CharacterDto): Character {
        return Character(
            id = characterDto.id,
            name = characterDto.name,
            status = characterDto.status,
            gender = characterDto.gender,
            image = characterDto.image,
            created = characterDto.created
        )
    }
}