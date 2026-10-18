package com.example.a76239_studentregistrationapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a76239_studentregistrationapp.room.StudentDao
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults

@Composable
fun SearchScreen(
    studentDao: StudentDao,
    onBack: () -> Unit
) {

    var studentId by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Find Student",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Enter Student ID") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {  //search for student ID
                val id = studentId.toIntOrNull()

                if (id == null || id <= 0) {
                    result = "Please enter a valid Student ID"
                } else {
                    scope.launch {
                        val student = studentDao.findStudent(id)

                        result = if (student != null) {
                            "Name: ${student.name}\nCourse: ${student.course}"
                        } else {
                            "Student not found"
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7B2CBF),
                contentColor = Color.White )
        ) {
            Text("SEARCH STUDENT")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = result)

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