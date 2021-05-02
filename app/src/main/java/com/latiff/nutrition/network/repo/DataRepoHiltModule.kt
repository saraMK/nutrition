package com.latiff.nutrition.network.repo


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRepoHiltModule {
    @Singleton
    @Provides
    fun getRepo(repo: DataRepoManger): DataRepo = repo
}