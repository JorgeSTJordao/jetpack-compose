package com.masterjorge.jetpackcomposeapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.time.Duration


@Composable
fun ScreenEx2(navController: NavHostController){
    DefaultPreview()
}

@Composable
fun LazyColumnSample(){

    val context = LocalContext.current
    val itens = (1..5).map { Itens(name = "Item ${it}") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(itens.size){ i ->
            Row (
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "Item ${i + 1} clicado",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .padding(15.dp)
            ){
                Text(text = itens[i].name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    LazyColumnSample()
}