package com.masterjorge.jetpackcomposeapp

sealed class Screens (
    val route: String
){
    object ScreenEx1: Screens("screen_ex1")
    object ScreenEx2: Screens("screen_ex2")
}