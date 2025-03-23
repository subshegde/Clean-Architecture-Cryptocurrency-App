package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_details.components

import com.example.cleanarchitecturecryptocurrencyapp.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coinDetail : CoinDetail? = null,
    val error: String = ""
)
