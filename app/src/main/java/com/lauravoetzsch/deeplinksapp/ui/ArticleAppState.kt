package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Grid : Screen("articles")
    object Name : Screen("articles/{name}") {
        fun createRoute(name: String) = "articles/$name"
    }
}

@Composable
fun rememberArticleAppState(
    navController: NavHostController = rememberNavController(),
) = remember(navController) {
    ArticleAppState(navController)
}

class ArticleAppState(
    val navController: NavHostController,
) {
    fun navigateToArticle(articleName: String) {
        navController.navigate(Screen.Name.createRoute(articleName))
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}