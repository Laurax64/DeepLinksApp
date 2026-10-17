package com.lauravoetzsch.deeplinksapp.data
import com.lauravoetzsch.deeplinksapp.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleLocalDataSource @Inject constructor(){
    val articleList = listOf(
        Article(
            id = 1,
            name = "Android App Architecture",
            date = "June 30, 2025 — Present",
            website = "https://sites.google.com/view/lauravoetzsch/articles/android-app-architecture",
            drawable = R.drawable.app_architecture
        ), Article(
            id = 2,
            name = "Requirements",
            date = "October 19, 2025",
            website = "https://sites.google.com/view/lauravoetzsch/articles/requirements",
            drawable = R.drawable.requirements

        )
    )
}