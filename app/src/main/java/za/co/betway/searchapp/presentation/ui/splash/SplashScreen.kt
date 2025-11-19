package za.co.betway.searchapp.presentation.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import za.co.betway.searchapp.presentation.ui.common.DefaultAppScreen

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onExitApp: () -> Unit,
    onNavigateSearch: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is SplashUiState.Loading -> {
            DefaultAppScreen(
                message = "Checking requirements...",
                showProgress = true
            )
        }

        is SplashUiState.Success -> {
            LaunchedEffect(Unit) { onNavigateSearch() }
        }

        is SplashUiState.NeedsPermission -> {
            DefaultAppScreen(
                message = "Internet permission is required.",
                actionLabel = "Ok",
                onActionClick = { onExitApp() }
            )
        }

        is SplashUiState.Error -> {
            val errorMessage = (uiState as SplashUiState.Error).message
            DefaultAppScreen(
                message = errorMessage,
                actionLabel = "Ok",
                onActionClick = { onExitApp() }
            )
        }
    }
}