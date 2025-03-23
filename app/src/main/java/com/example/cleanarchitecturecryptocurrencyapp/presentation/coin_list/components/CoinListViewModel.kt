package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase): ViewModel() {
    private val _state = mutableStateOf<CoinListState>()
}