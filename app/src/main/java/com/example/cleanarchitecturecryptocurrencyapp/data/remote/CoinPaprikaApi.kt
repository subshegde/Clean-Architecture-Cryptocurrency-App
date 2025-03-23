package com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto

import com.example.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

// retrofit api interface
interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailsDto
}