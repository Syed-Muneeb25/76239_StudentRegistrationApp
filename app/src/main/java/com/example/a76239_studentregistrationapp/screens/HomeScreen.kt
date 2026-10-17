package com.example.a76239_studentregistrationapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onAddStudent: () -> Unit,
    onFindStudent: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Student Registration App",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Student Registration",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onAddStudent,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ADD STUDENT")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onFindStudent,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("FIND STUDENT")
        }
    }
}