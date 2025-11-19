package za.co.betway.searchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import za.co.betway.searchapp.presentation.navigation.AppNavGraph
import za.co.betway.searchapp.presentation.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    onExitApp = { finishAffinity() }
                )
            }
        }
    }
}