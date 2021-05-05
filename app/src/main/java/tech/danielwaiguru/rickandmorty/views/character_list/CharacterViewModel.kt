package tech.danielwaiguru.rickandmorty.views.character_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import tech.danielwaiguru.domain.models.Character
import tech.danielwaiguru.domain.use_cases.GetCharactersUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterListUseCase: GetCharactersUseCase
): ViewModel() {
    val morties = mutableStateOf<List<Character>>(listOf())
    val isLoading = mutableStateOf(false)
    val onError = mutableStateOf("")
    init {
        getAllCharacters()
    }
    fun getAllCharacters() {
        viewModelScope.launch {
            characterListUseCase.invoke()
                .onStart {
                    isLoading.value = true
                }
                .catch { exception ->
                    isLoading.value = false
                    onError.value = exception.message.toString()
                }
                .collect {
                    isLoading.value = false
                    morties.value = it
                }
        }
    }
}