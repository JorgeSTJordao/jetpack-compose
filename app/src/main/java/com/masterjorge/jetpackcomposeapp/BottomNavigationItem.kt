package com.masterjorge.jetpackcomposeapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = ""
){
    //Lista de botões
    fun bottomNavigationitems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Ex1",
                icon = Icons.Filled.Home,
                route = Screens.ScreenEx1.route
            )
        )
    }
}