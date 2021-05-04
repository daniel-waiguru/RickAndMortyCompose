package tech.danielwaiguru.rickandmorty.models

sealed class ResultWrapper<out T>{
    data class Success<T>(val data: T): ResultWrapper<T>()
    data class Error<T>(val errorMessage: String?, val exception: Exception?): ResultWrapper<T>()
    object Loading: ResultWrapper<Nothing>()
}