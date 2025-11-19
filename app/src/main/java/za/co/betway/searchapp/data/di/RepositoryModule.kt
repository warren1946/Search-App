package za.co.betway.searchapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import za.co.betway.searchapp.data.remote.api.StackOverflowApi
import za.co.betway.searchapp.data.repository.StackOverflowRepositoryImpl
import za.co.betway.searchapp.domain.repository.StackOverflowRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(api: StackOverflowApi): StackOverflowRepository =
        StackOverflowRepositoryImpl(api)
}