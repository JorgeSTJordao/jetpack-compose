package com.masterjorge.jetpackcomposeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.masterjorge.jetpackcomposeapp.screens.ScreenEx1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(){
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationitems().forEachIndexed{
                    index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(text = navigationItem.label)
                        },
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            ) })
                }
            }
        }
    ){
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.ScreenEx1.route,
            modifier = Modifier.padding(
                paddingValues = paddingValues
            )){
            composable(Screens.ScreenEx1.route){
                ScreenEx1()
            }
        }
    }
}