package com.daffa.batur.presentation.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object OnBoardingScreen : Screen("on_boarding_screen")
    object RegisterScreen : Screen("register_screen")
    object HomeScreen : Screen("home_screen")
    object GameMapScreen : Screen("map_screen")
    object ProfileScreen : Screen("profile_screen")
    object QuizScreen : Screen("quiz_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}