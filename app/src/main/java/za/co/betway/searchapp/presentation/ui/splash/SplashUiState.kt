package za.co.betway.searchapp.presentation.ui.splash

sealed class SplashUiState {
    object Loading : SplashUiState()
    object Success : SplashUiState()
    object NeedsPermission : SplashUiState()
    data class Error(val message: String) : SplashUiState()
}