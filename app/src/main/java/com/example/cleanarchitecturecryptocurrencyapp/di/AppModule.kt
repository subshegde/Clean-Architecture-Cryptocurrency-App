package com.example.cleanarchitecturecryptocurrencyapp.di

import com.example.cleanarchitecturecryptocurrencyapp.common.Constants
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinPaprikaApi
import com.example.cleanarchitecturecryptocurrencyapp.data.repository.CoinRepositoryImplementation
import com.example.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides // provides the dependencies
    @Singleton //only have single install
    fun  providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository{
        return CoinRepositoryImplementation(api)
    }
}