package za.co.betway.searchapp.presentation.ui.splash

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onExitApp: () -> Unit,
    onNavigateHome: () -> Unit
) {

}