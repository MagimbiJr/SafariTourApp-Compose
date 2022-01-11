package com.tana.safaritour.authentication.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tana.safaritour.R
import com.tana.safaritour.authentication.login.data.LoginCredential
import com.tana.safaritour.ui.components.buttons.FederationSignButton
import com.tana.safaritour.ui.components.buttons.PrimaryButton
import com.tana.safaritour.ui.components.textfield.STTextField
import com.tana.safaritour.ui.theme.SafariTourTheme


@Composable
fun LoginContent(
    loginUiState: LoginUiState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginButtonClicked: () -> Unit,
    onCreateAccountButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = modifier.height(64.dp))
            FederationSignButton(
                text = "Sign in with google",
                image = R.drawable.google_logo,
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = modifier.height(24.dp))
            Text(
                text = "Or",
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = modifier.height(24.dp))
            LoginUserInput(
                loginUiState = loginUiState,
                onEmailChanged = onEmailChanged,
                onPasswordChanged = onPasswordChanged,
                onLoginButtonClicked = onLoginButtonClicked,
                emailInputErrorMessage = (loginUiState as? LoginUiState)?.emailInputErrorMessage,
                passwordInputErrorMessage = (loginUiState as? LoginUiState)?.passwordInputErrorMessage,
            )
            if (loginUiState.errorMessage != null) {
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = loginUiState.errorMessage,
                    color = MaterialTheme.colors.error
                )
            }
            Spacer(modifier = modifier.height(24.dp))
            LoginActionButtons(
                modifier = modifier,
                onLoginButtonClicked = onLoginButtonClicked,
                onCreateAccountButtonClicked = onCreateAccountButtonClicked,
            )
        }
    }
}

@Composable
fun LoginActionButtons(
    modifier: Modifier,
    onLoginButtonClicked: () -> Unit,
    onCreateAccountButtonClicked: () -> Unit,
) {
    PrimaryButton(
        text = "Login",
        onClick = onLoginButtonClicked,
        enabled = true
    )
    Spacer(modifier = modifier.height(12.dp))
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Don't have an account?")
        Spacer(modifier = modifier.width(12.dp))
        Text(
            text = "Create account",
            modifier = modifier
                .clickable { onCreateAccountButtonClicked() },
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun LoginUserInput(
    loginUiState: LoginUiState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginButtonClicked: () -> Unit,
    emailInputErrorMessage: String?,
    passwordInputErrorMessage: String?,
) {
    val focusManager = LocalFocusManager.current
    STTextField(
        text = loginUiState.credentials.email,
        onTextChange = onEmailChanged,
        label = "Email",
        errorMessage = emailInputErrorMessage,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    STTextField(
        text = loginUiState.credentials.password,
        onTextChange = onPasswordChanged,
        label = "Password",
        errorMessage = passwordInputErrorMessage,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                onLoginButtonClicked()
            }
        )
    )
}


@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)

@Preview(
    name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun LoginContentPreview() {
    val uiState = LoginUiState(
        credentials = LoginCredential(password = "1234567"),
        errorMessage = "Something went wrong",

    )
    SafariTourTheme() {
        Surface {
            LoginContent(
                loginUiState = uiState,
                onEmailChanged = {},
                onPasswordChanged = {},
                onLoginButtonClicked = {},
                onCreateAccountButtonClicked = {}
            )
        }
    }
}