package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lauravoetzsch.deeplinksapp.R
import com.lauravoetzsch.deeplinksapp.data.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleGrid(
    articles: List<Article>,
    onArticleSelected: (String) -> Unit,
    navigateToArticle: (String) -> Unit,
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Articles") }
        )
    }) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 400.dp),
            modifier = Modifier.padding(paddingValues),
        ) {
            items(items = articles) { article ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            onArticleSelected(article.name)
                            navigateToArticle(article.name)
                        })
                ) {
                    ArticleCell(article)
                }
            }
        }
    }
}

@Preview
@Composable
fun ArticleGridPreview() {
    ArticleGrid(
        articles = listOf(
            Article(
                id = 1,
                name = "Android App Architecture",
                date = "June 30, 2025 - Present",
                website = "https://sites.google.com/view/lauravoetzsch/articles/android-app-architecture",
                drawable = R.drawable.app_architecture
            ),
            Article(
                id = 2,
                name = "Requirements",
                date = "October 19, 2025",
                website = "https://sites.google.com/view/lauravoetzsch/articles/requirements",
                drawable = R.drawable.requirements
            )
        ),
        onArticleSelected = {},
        navigateToArticle = {}
    )
}