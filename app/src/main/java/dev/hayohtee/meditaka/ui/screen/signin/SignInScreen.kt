package dev.hayohtee.meditaka.ui.screen.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.meditaka.R
import dev.hayohtee.meditaka.ui.component.RegistrationButton
import dev.hayohtee.meditaka.ui.component.RegistrationCard
import dev.hayohtee.meditaka.ui.component.RegistrationHeader
import dev.hayohtee.meditaka.ui.component.RegistrationTextField
import dev.hayohtee.meditaka.ui.theme.MeditakaTheme

@Composable
fun SignInScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.fillMaxSize()
    ) {
        SignInScreenContent()
    }
}


@Composable
fun SignInScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large_padding))
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.large_padding)))
        RegistrationHeader(
            title = stringResource(id = R.string.sign_in),
            body = stringResource(id = R.string.sign_in_text),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        RegistrationCard(
            onMyAccountClick = { /*TODO*/ },
            onRegisterClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            RegistrationTextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.enter_your_email))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.message),
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            RegistrationTextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock),
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.hide),
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            RegistrationButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.small_padding))
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MeditakaTheme {
        SignInScreen()
    }
}