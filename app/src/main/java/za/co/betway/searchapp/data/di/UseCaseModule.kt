package za.co.betway.searchapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import za.co.betway.searchapp.domain.usecase.GetAnswersUseCase
import za.co.betway.searchapp.domain.usecase.SearchQuestionsUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideSearchQuestionsUseCase(repository: StackOverflowRepository) =
        SearchQuestionsUseCase(repository)

    @Provides
    fun provideGetAnswersUseCase(repository: StackOverflowRepository) =
        GetAnswersUseCase(repository)
}