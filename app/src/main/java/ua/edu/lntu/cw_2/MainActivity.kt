package ua.edu.lntu.cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw_2.ui.theme.IPZ_CW_2_Hasyuk_VitalyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2_Hasyuk_VitalyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SignInPage(
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var signInSuccess by remember { mutableStateOf(false) }

    if(!signInSuccess) {
        Column() {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("email@email.com") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("password") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                    signInSuccess = true
                }
            }) {
                Text("Sign In")
            }
        }
    }
    else {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Sign In success")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Email: ${email.text}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                signInSuccess = false
                email = TextFieldValue()
                password = TextFieldValue()
            }) {
                Text("Sign Out")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPZ_CW_2_Hasyuk_VitalyTheme {

    }
}