package tech.danielwaiguru.rickandmorty.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import tech.danielwaiguru.domain.use_cases.GetCharactersUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterListUseCase: GetCharactersUseCase
): ViewModel() {
    fun getAllCharacters() {
        viewModelScope.launch {
            characterListUseCase.invoke()
                .onStart {
                    //emit loading state
                }
                .catch { exception ->
                    // throw exception
                }
                .collect { characters ->
                    //notify ui
                }
        }
    }
}