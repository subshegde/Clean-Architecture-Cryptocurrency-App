package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list.components.CoinListItem
import com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list.components.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins){coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate()
                    }
                )
            }
        }
    }
}