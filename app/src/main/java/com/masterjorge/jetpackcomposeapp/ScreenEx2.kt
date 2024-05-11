package com.masterjorge.jetpackcomposeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ScreenEx2(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyColumnSample()
    }
}

@Composable
fun TextComposable(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
}

@Composable
fun Title(){
    TextComposable("Hello, World")
}


@Composable
fun LazyColumnSample(){
    Title()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    LazyColumnSample()
    Text(text = "Hey")
}