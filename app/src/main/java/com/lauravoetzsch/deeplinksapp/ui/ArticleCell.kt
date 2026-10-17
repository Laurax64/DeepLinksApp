package com.lauravoetzsch.deeplinksapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lauravoetzsch.deeplinksapp.R
import com.lauravoetzsch.deeplinksapp.data.Article

@Composable
fun ArticleCell(
    article: Article
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text(text = article.name, style = MaterialTheme.typography.titleSmall)
            Text(text = article.date, style = MaterialTheme.typography.labelSmall)
            Image(
                painter = painterResource(id = article.drawable),
                contentDescription = article.name,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)

            )

        }
    }
}

@Preview
@Composable
fun ArticleCellPreview() {
    ArticleCell(
        article = Article(
            id = 1,
            name = "Android App Architecture",
            date = "June 30, 2025 — Present",
            website = "https://sites.google.com/view/lauravoetzsch/articles/android-app-architecture",
            drawable = R.drawable.app_architecture
        )
    )

}
