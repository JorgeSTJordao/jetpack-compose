package com.masterjorge.jetpackcomposeapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.masterjorge.jetpackcomposeapp.R

@Composable
fun ScreenEx2(navController: NavController){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color("#ff6666".toColorInt()))
            .padding(15.dp)
    ) {
        ElevatedCard (
            modifier = Modifier
                .size(
                    width = 340.dp,
                    height = 140.dp
                )
        ) {
            Row (
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Image(
                    painter =
                    painterResource(id = R.drawable.eu),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape))
                Column {
                    Text(text = "Desenvolvedor Android")
                    Button(onClick = {}){
                        Text(text = "Sobre mim")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2(){
    ScreenEx2(
        navController = NavController(LocalContext.current)
    )
}