package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_details.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturecryptocurrencyapp.common.Constants
import com.example.cleanarchitecturecryptocurrencyapp.common.Resource
import com.example.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import com.example.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<CoinState>(CoinState())
    val state: State<CoinState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String){
        getCoinDetailUseCase(coinId = coinId).onEach { result ->
            run {
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinState(coinDetail = result.data)
                    }

                    is Resource.Error -> {
                        _state.value =
                            CoinState(error = result.message ?: "An unexpected error occurred")
                    }

                    is Resource.Loading -> {
                        _state.value = CoinState(isLoading = true)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}