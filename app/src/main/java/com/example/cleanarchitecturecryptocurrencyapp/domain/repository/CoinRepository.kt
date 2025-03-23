package com.example.cleanarchitecturecryptocurrencyapp.domain.repository

import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDetailsDto
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId : String) : CoinDetailsDto
}