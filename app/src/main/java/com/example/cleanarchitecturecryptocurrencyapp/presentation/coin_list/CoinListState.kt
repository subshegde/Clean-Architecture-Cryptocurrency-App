package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list.components

import com.example.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import java.lang.Error

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
