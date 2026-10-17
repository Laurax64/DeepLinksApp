package com.lauravoetzsch.deeplinksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lauravoetzsch.deeplinksapp.ui.ArticleApp
import com.lauravoetzsch.deeplinksapp.ui.theme.DeepLinksAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepLinksAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArticleApp()
                }
            }
        }
    }
}