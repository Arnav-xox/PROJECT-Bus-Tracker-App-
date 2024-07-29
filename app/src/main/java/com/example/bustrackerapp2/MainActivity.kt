package com.example.bustrackerapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.bustrackerapp2.ui.theme.BusTrackerApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusTrackerApp2Theme {
                // A surface container using the background color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    AuthScreen()
                }
            }
        }
    }
}

@Composable
fun AuthScreen() {
    var isLogin by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToggleButton(isLogin) { isLogin = !isLogin }
        Spacer(modifier = Modifier.height(16.dp))
        if (isLogin) {
            LoginForm()
        } else {
            SignUpForm()
        }
    }
}

@Composable
fun ToggleButton(isLogin: Boolean, onToggle: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onToggle,
            colors = ButtonDefaults.run {
                buttonColors(
                    containerColor = if (!isLogin) Color.Gray else Color.Blue
                    )
            }
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onToggle,
            colors = ButtonDefaults.run {
                buttonColors(
                    containerColor = if (isLogin) Color.Gray else Color.Blue
                    )
            }
        ) {
            Text("Sign Up")
        }
    }
}

@Composable
fun LoginForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Handle Login Click */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Login")
        }
    }
}

@Composable
fun SignUpForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Sign Up", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Handle Sign Up Click */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Sign Up")
        }
    }
}
