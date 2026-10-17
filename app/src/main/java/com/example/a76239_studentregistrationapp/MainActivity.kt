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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a76239_studentregistrationapp.screens.RegistrationScreen
import com.example.a76239_studentregistrationapp.screens.SearchScreen
import androidx.room.Room
import com.example.a76239_studentregistrationapp.room.StudentDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val database = Room.databaseBuilder(
            applicationContext,
            StudentDatabase::class.java,
            "student_database"
        ).build()

        val studentDao = database.studentDao()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _76239_StudentRegistrationAppTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            onAddStudent = {
                                navController.navigate("register")
                            },
                            onFindStudent = {
                                navController.navigate("search")
                            }
                        )
                    }

                    composable("register") {
                        RegistrationScreen(studentDao = studentDao)
                    }

                    composable("search") {
                        SearchScreen()
                    }
                }

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