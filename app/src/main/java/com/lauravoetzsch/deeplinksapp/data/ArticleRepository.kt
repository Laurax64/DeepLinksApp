package com.lauravoetzsch.deeplinksapp.data

import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource
) {
    val article: List<Article> = articleLocalDataSource.articleList

    // Method to obtain an article object by its name
    fun getArticleByName(name: String): Article? {
        return articleLocalDataSource.articleList.find { article ->
            val processedName = article.name.filterNot { it.isWhitespace() }.lowercase()
            val nameToTest = name.filterNot { it.isWhitespace() }.lowercase()
            nameToTest == processedName
        }
    }
}