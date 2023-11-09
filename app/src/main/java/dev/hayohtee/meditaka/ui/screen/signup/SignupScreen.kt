package dev.hayohtee.meditaka.ui.screen.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.meditaka.R
import dev.hayohtee.meditaka.ui.component.RegistrationButton
import dev.hayohtee.meditaka.ui.component.RegistrationCard
import dev.hayohtee.meditaka.ui.component.RegistrationHeader
import dev.hayohtee.meditaka.ui.component.RegistrationTextField
import dev.hayohtee.meditaka.ui.theme.MeditakaTheme

@Composable
fun SignupScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.fillMaxSize()
    ) {
        SignupScreenContent()
    }
}

@Composable
fun SignupScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.medium_padding))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large_padding))
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.large_padding)))
        RegistrationHeader(
            title = stringResource(id = R.string.register),
            body = stringResource(id = R.string.register_text),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        RegistrationCard(
            onMyAccountClick = { /*TODO*/ },
            onRegisterClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            enableFirst = true
        ) {
            RegistrationTextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.full_name))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Sentences
                )
            )

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

            Row(
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primary,
                        uncheckedColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = stringResource(id = R.string.i_accepted),
                    style = MaterialTheme.typography.bodyLarge
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.terms_and_privacy_policy),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            RegistrationButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.register_button_text),
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
fun DefaultPreview() {
    MeditakaTheme {
        SignupScreen()
    }
}