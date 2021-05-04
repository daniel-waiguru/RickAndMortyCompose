package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.CharacterRepository

class GetCharactersUseCase(private val characterRepo: CharacterRepository) {
    suspend operator fun invoke() = characterRepo.getCharacters()
}