package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Articles",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Deep Links & Android Architecture",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 320.dp),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(items = articles, key = { it.id }) { article ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .clickable(onClick = {
                            onArticleSelected(article.name)
                            navigateToArticle(article.name)
                        })
                ) {
                    ArticleCell(article = article)
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
