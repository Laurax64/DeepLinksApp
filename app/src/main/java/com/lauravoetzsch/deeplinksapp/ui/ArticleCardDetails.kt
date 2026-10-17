package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lauravoetzsch.deeplinksapp.R
import com.lauravoetzsch.deeplinksapp.data.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleCardDetails(
    article: Article,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = article.name) },
                modifier = Modifier.fillMaxWidth(),
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_arrow_back_24),
                            contentDescription = "Arrow Back",
                        )
                    }
                },
            )
        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
        ) {
            Text(text = article.date, style = MaterialTheme.typography.labelLarge)
            SelectionContainer {
                Text(text = article.website, style = MaterialTheme.typography.labelSmall)
            }
            Image(
                painter = painterResource(id = article.drawable),
                contentDescription = article.name
            )
        }
    }
}

@Preview
@Composable
fun ArticleCardDetailsPreview() {
    ArticleCardDetails(
        article = Article(
            id = 1,
            name = "Android App Architecture",
            date = "June 30, 2025 — Present",
            website = "https://sites.google.com/view/lauravoetzsch/articles/android-app-architecture",
            drawable = R.drawable.app_architecture
        ),
        onBack = {}
    )
}
