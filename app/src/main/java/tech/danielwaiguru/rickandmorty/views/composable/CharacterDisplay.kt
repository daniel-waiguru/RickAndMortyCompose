package tech.danielwaiguru.rickandmorty.views.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import tech.danielwaiguru.domain.models.Character


@Composable
fun DisplayCharacters(
    characters:List<Character>, onCharacterClicked: (Character) -> Unit
) {
    LazyColumn {
        items(characters) { character ->
            CharacterCardItem(
                character = character
            ) {
                onCharacterClicked(it)
            }
        }
    }
}