package com.example.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coins

import com.example.cleanarchitecturecryptocurrencyapp.common.Resource
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.toCoin
import com.example.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import com.example.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// inject the interface (repository) not repository implementation
class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("Could not reach server, Check your internet connection!"))
        }
    }
}