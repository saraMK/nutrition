package com.latiff.nutrition.network.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRepoHiltModuleTest {
    @Singleton
    @Provides
    @Named("FakeRepo")
    fun getRepo( @Named("FakeDataRepo")repo: FakeDataRepo): DataRepo = repo
}