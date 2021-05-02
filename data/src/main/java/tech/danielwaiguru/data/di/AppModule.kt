package tech.danielwaiguru.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.domain.repository.CharacterRepository
import tech.danielwaiguru.domain.use_cases.GetCharacterDetailsUseCase
import tech.danielwaiguru.domain.use_cases.GetCharactersUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGetCharactersUseCase(characterRepo: CharacterRepository): GetCharactersUseCase {
        return GetCharactersUseCase(characterRepo)
    }
    @Provides
    @Singleton
    fun provideGetCharacterDetails(characterRepo: CharacterRepository): GetCharacterDetailsUseCase{
        return GetCharacterDetailsUseCase(characterRepo)
    }
}