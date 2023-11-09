package dev.hayohtee.meditaka.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.meditaka.R
import dev.hayohtee.meditaka.ui.theme.MeditakaTheme

@Composable
fun RegistrationHeader(title: String, body: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = body,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MeditakaTheme {
        RegistrationHeader(
            title = stringResource(id = R.string.sign_in),
            body = stringResource(id = R.string.sign_in_text)
        )
    }
}