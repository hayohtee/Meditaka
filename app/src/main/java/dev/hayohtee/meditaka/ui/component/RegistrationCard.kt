package dev.hayohtee.meditaka.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hayohtee.meditaka.R
import dev.hayohtee.meditaka.ui.theme.MeditakaTheme

@Composable
fun RegistrationCard(
    onMyAccountClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
    enableFirst: Boolean = false,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(10)
    ) {
        RegistrationCardContent(
            onMyAccountClick = onMyAccountClick,
            onRegisterClick = onRegisterClick,
            enableFirst = enableFirst,
            content = content,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding))
        )
    }
}

@Composable
fun RegistrationCardContent(
    onMyAccountClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
    enableFirst: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        ButtonGroup(
            onMyAccountClick = onMyAccountClick,
            onRegisterClick = onRegisterClick,
            enableFirst = enableFirst
        )
        content()
    }
}

@Composable
fun ButtonGroup(
    onMyAccountClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
    enableFirst: Boolean = false
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        shape = RoundedCornerShape(30)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.small_padding))
        ) {
            RegistrationCardButton(
                onClick = onMyAccountClick,
                enabled = enableFirst,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.my_account))
            }
            RegistrationCardButton(
                onClick = onRegisterClick,
                modifier = Modifier.weight(1f),
                enabled = !enableFirst
            ) {
                Text(text = stringResource(id = R.string.register))
            }
        }
    }
}

@Composable
fun RegistrationCardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        content = content,
        modifier = modifier.heightIn(min = 60.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = RoundedCornerShape(25)
    )
}

@Preview(showBackground = true)
@Composable
fun RegistrationCardButtonPreview() {
    MeditakaTheme {
        RegistrationCardButton(
            onClick = {},
            modifier = Modifier.padding(dimensionResource(id = R.dimen.small_padding))
        ) {
            Text(text = stringResource(id = R.string.my_account))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonGroupPreview() {
    MeditakaTheme {
        ButtonGroup(
            onMyAccountClick = {},
            onRegisterClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MeditakaTheme {
        RegistrationCard(
            onRegisterClick = {},
            onMyAccountClick = {},
            content = {},
        )
    }
}