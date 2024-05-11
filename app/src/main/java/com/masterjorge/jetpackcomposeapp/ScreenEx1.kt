package com.masterjorge.jetpackcomposeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//Usamos para criar uma nova tela
@Composable
fun ScreenEx1(navController: NavHostController){

    //Posição da lista e seus valores
    val sentences = listOf(
        "Linkin Park", "Simple Plan", "Nirvana", "The Beatles", "Rolling Stones", "Guns N'Roses"
    )
    val i = 0
    //O mutable state permite que o aplicativo se lembre da variável a partir do momento em que
    //a Activity é atualizada
    val j = remember { mutableIntStateOf(i) }

    //Estrutura no formato de coluna
    Row(
        modifier = Modifier
            .padding(15.dp),
        horizontalArrangement = Arrangement.End
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                navController.navigate("screex2")
            },
            containerColor = colorResource(id = R.color.blue_white)
        ) {
            Icon(Icons.Filled.ArrowForward, contentDescription = null)
            Text(text = "Next page")
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        SimpleColumn(j, sentences, navController = navController)
    }
}

//Cria uma coluna e seus elementos
@Composable
fun SimpleColumn(j: MutableIntState, sentences: List<String>, navController: NavHostController){


    Text(text = "HomeScreen - Ex1", fontSize = 35.sp)

    Button(
        onClick = {
        j.intValue += 1

        if (j.intValue > sentences.size - 1)
            j.intValue = 0
         },
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue_white))
        )
    {
        Text(text = "Banda do dia", color = Color.Black)
    }

    Text(text = sentences[j.intValue], fontWeight = FontWeight.Bold, fontSize = 25.sp)
}