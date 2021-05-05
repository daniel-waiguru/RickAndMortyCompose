package tech.danielwaiguru.rickandmorty.views.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tech.danielwaiguru.rickandmorty.R

@Composable
fun ShowError(text: String, onButtonClick: () -> Unit) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "Error",
            modifier = Modifier.padding(50.dp)
        )

        Button(onClick = {
            onButtonClick()
        },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(text = "Retry"
            )
        }
    }
}