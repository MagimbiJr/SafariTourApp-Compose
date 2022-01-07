package com.tana.safaritour.authentication.signup.ui

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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tana.safaritour.R
import com.tana.safaritour.ui.components.buttons.FederationSignButton
import com.tana.safaritour.ui.components.buttons.PrimaryButton
import com.tana.safaritour.ui.components.textfield.STTextField
import com.tana.safaritour.ui.theme.SafariTourTheme

@Composable
fun SignUpContent(
    //signUpUiState: SignUpUiState
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onReTypePasswordChanged: (String) -> Unit,
    onSignUpButtonClicked: () -> Unit,
    onLoginButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign Up",
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
        UserInputs(
            onNameChanged,
            modifier,
            onEmailChanged,
            onPasswordChanged,
            onReTypePasswordChanged,
            onGoButtonClicked = onSignUpButtonClicked
        )
        Spacer(modifier = modifier.height(24.dp))
        ActionButtons(onSignUpButtonClicked, modifier, onLoginButtonClicked)
    }
}

@Composable
fun ActionButtons(
    onSignUpButtonClicked: () -> Unit,
    modifier: Modifier,
    onLoginButtonClicked: () -> Unit
) {
    PrimaryButton(
        text = "Create account",
        onClick = onSignUpButtonClicked,
        enabled = true
    )
    Spacer(modifier = modifier.height(12.dp))
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Already have an account?")
        Spacer(modifier = modifier.width(12.dp))
        Text(
            text = "Login",
            modifier = modifier
                .clickable { onLoginButtonClicked() },
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun UserInputs(
    onNameChanged: (String) -> Unit,
    modifier: Modifier,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onReTypePasswordChanged: (String) -> Unit,
    onGoButtonClicked: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    STTextField(
        text = "",
        onTextChange = onNameChanged,
        label = "Name",
        isError = false,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    Spacer(modifier = modifier.height(12.dp))
    STTextField(
        text = "",
        onTextChange = onEmailChanged,
        label = "Email",
        isError = false,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    Spacer(modifier = modifier.height(12.dp))
    STTextField(
        text = "",
        onTextChange = onPasswordChanged,
        label = "Password",
        isError = false,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
    Spacer(modifier = modifier.height(12.dp))
    STTextField(
        text = "",
        onTextChange = onReTypePasswordChanged,
        label = "Verify password",
        isError = false,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onGo = { onGoButtonClicked() }
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
fun SignUpContentPreview() {
    SafariTourTheme {
        Surface() {
            SignUpContent(
                onNameChanged = {},
                onEmailChanged = {},
                onPasswordChanged = {},
                onReTypePasswordChanged = {},
                onSignUpButtonClicked = {},
                onLoginButtonClicked = {}
            )
        }
    }
}