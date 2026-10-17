package com.example.a76239_studentregistrationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a76239_studentregistrationapp.screens.HomeScreen
import com.example.a76239_studentregistrationapp.ui.theme._76239_StudentRegistrationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _76239_StudentRegistrationAppTheme {
                    HomeScreen(
                        onAddStudent = { },
                        onFindStudent = { }
                    )
                }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _76239_StudentRegistrationAppTheme {
        Greeting("Android")
    }
}