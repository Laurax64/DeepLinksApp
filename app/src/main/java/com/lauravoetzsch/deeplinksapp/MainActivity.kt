package com.lauravoetzsch.deeplinksapp


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.lauravoetzsch.deeplinksapp.ui.ArticleApp
import com.lauravoetzsch.deeplinksapp.ui.theme.DeepLinksAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepLinksAppTheme {
                handleIntent(intent)
                ArticleApp()
            }
        }
    }
}
private fun handleIntent(intent: Intent?) {
    android.util.Log.d("DeepLinks", "Action: ${intent?.action}")
    android.util.Log.d("DeepLinks", "Data: ${intent?.data}")
    android.util.Log.d("DeepLinks", "Path: ${intent?.data?.path}")
}