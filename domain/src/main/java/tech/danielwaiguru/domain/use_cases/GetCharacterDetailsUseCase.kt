package tech.danielwaiguru.domain.use_cases

import tech.danielwaiguru.domain.repository.CharacterRepository

class GetCharacterDetailsUseCase(private val characterRepo: CharacterRepository) {
    suspend operator fun invoke(id: Int) = characterRepo.getCharacterDetails(id)
}