package com.example.deeplinksbasics

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.deeplinksbasics.ui.theme.DeepLinksBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Receive the intent action and data
        val action: String? = intent?.action;
        val data: Uri? = intent?.data;

        enableEdgeToEdge()
        setContent {
            DeepLinksBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Add a Column to print a message per line
                    Column(modifier = Modifier.padding(innerPadding)) {
                        // Print it on the home screen
                        Greeting("Android")
                        Text(text = "Action: $action")
                        Text(text = "Data: $data")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeepLinksBasicsTheme {
        Greeting("Android")
    }
}