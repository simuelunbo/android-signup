package nextstep.signup.component.textField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.model.EmailState
import nextstep.signup.valid.RegexBasedSignUpValidator
import nextstep.signup.valid.SignUpValidator

@Composable
fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
    onValidationResult: (Boolean) -> Unit,
    validator: SignUpValidator = RegexBasedSignUpValidator()
) {
    val emailState by remember(email) {
        derivedStateOf { validator.validateEmail(email) }
    }

    LaunchedEffect(emailState) {
        onValidationResult(emailState is EmailState.Valid)
    }

    BaseSignUpTextField(
        text = email,
        onValueChange = onEmailChange,
        label = stringResource(R.string.sign_up_text_field_email),
        isError = emailState is EmailState.Invalid,
        errorMessage = when (emailState) {
            EmailState.Invalid -> stringResource(R.string.sig_nup_error_email_invalid)
            EmailState.Valid, EmailState.Initial -> ""
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EmailTextFieldPreview() {
    EmailTextField(
        email = "example@email.com",
        onEmailChange = {},
        onValidationResult = {}
    )
}