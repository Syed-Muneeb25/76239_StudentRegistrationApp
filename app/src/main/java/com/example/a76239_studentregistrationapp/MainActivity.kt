package com.example.a76239_studentregistrationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
// connects to database
        val studentDao = database.studentDao()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _76239_StudentRegistrationAppTheme {

                val navController = rememberNavController()

                NavHost(  //handles navigation between screens
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
                        RegistrationScreen(
                            studentDao = studentDao,
                            onBack = { navController.popBackStack() }
                        )
                    }

                    composable("search") {
                        SearchScreen(
                            studentDao = studentDao,
                            onBack = { navController.popBackStack() }
                        )
                    }

                }

            }
            }
        }
    }