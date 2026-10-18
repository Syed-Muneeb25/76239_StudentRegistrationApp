package com.example.a76239_studentregistrationapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.rememberCoroutineScope
import com.example.a76239_studentregistrationapp.room.Student
import com.example.a76239_studentregistrationapp.room.StudentDao
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults

@Composable
fun RegistrationScreen(
    studentDao: StudentDao,
    onBack: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Registration",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year (1-4)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val studentYear = year.toIntOrNull()

                message = when {  //checks for errors
                    name.isBlank() || course.isBlank() ->
                        "Please fill in all fields"

                    studentYear == null || studentYear !in 1..4 ->  //check for year between 1 and 4
                        "Year must be between 1 and 4"

                    else -> {
                        scope.launch {
                            val id = studentDao.insertStudent( //saves student info into database
                                Student(
                                    name = name.trim(),
                                    course = course.trim(),
                                    year = studentYear
                                )
                            )

                            message = "Student registered successfully! ID: $id"

                            name = ""
                            course = ""
                            year = ""
                        }

                        ""
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7B2CBF),
                contentColor = Color.White )
        ) {
            Text("REGISTER STUDENT")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = message)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7B2CBF),
                contentColor = Color.White )
        ) {
            Text("Back to Homepage")
        }

    }
}
