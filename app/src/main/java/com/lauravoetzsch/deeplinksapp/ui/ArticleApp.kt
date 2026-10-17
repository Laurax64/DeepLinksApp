package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

@Composable
fun ArticleApp(
    viewModel: ArticleViewModel = viewModel(),
    appState: ArticleAppState = rememberArticleAppState(),
) {
    val selectedArticle by viewModel.selectedArticle.collectAsState()
    val onArticleSelected: (String) -> Unit = { viewModel.updateSelectedArticleByName(it) }

    NavHost(
        navController = appState.navController,
        startDestination = Screen.Grid.route,
    ) {
        // Default route that points to the article grid
        composable(Screen.Grid.route) {
            ArticleGrid(
                articles = viewModel.articles,
                onArticleSelected = onArticleSelected,
                navigateToArticle = { articleName ->
                    appState.navigateToArticle(articleName)
                },
            )
        }

        // Route for navigation to a particular article when selected or via deep link
        composable(
            route = Screen.Name.route,
            deepLinks = listOf(
                navDeepLink { uriPattern = "https://sites.google.com/view/lauravoetzsch/articles/{name}" }
            ),
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val articleName = entry.arguments?.getString("name")
            if (articleName != null) {
                LaunchedEffect(articleName) {
                    viewModel.updateSelectedArticleByName(articleName)
                }
            }
            selectedArticle?.let { article ->
                ArticleCardDetails(
                    article = article,
                    onBack = appState::navigateBack
                )
            }
        }
    }
}
