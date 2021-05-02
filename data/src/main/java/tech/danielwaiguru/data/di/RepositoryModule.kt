package tech.danielwaiguru.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.danielwaiguru.data.repository.CharacterRepositoryImpl
import tech.danielwaiguru.domain.repository.CharacterRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideCharacterRepo(
        characterRepImpl: CharacterRepositoryImpl): CharacterRepository
}