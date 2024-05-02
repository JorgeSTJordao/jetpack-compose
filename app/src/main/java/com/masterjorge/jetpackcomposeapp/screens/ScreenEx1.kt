package com.masterjorge.jetpackcomposeapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenEx1(navController: NavController){

    val context = LocalContext.current

    val options = listOf(
        "Soma ",
        "Subtração",
        "Multiplicação",
        "Divisão"
        )

    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedOptionText by remember {
        mutableStateOf(options[0])
    }

    //Local do conteúdo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color("#b3ffb3".toColorInt()))
            .padding(25.dp),
    ) {
        
        Text(
            modifier = Modifier
                .padding(
                    bottom = 15.dp
                ),
            text = "Selecione um dos operadores: ",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp)

        //Dropdown
        ExposedDropdownMenuBox(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)),
            expanded = expanded,
            onExpandedChange = { expanded = it},)
        {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedOptionText,
                onValueChange = {},
                label = { Text(text = "Operador")},
                trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {

                options.forEach {selectionFont ->
                    DropdownMenuItem(
                        text = { Text(text = selectionFont) },
                        onClick = {
                            selectedOptionText = selectionFont
                            expanded = false
                            toastMessage(context, selectedOptionText)
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}


//Função para mostrar o Toast
fun toastMessage(context: Context, selectedOptionText: String) =
    Toast.makeText(context, selectedOptionText, Toast.LENGTH_SHORT).show()


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ScreenEx1(
        navController = NavController(LocalContext.current)
    )
}