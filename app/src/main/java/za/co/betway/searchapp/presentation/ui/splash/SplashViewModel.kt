package za.co.betway.searchapp.presentation.ui.splash

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import za.co.betway.searchapp.presentation.utils.NetworkUtils
import za.co.betway.searchapp.presentation.utils.PermissionManager
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val permissionManager: PermissionManager, @ApplicationContext private val context: Context) : ViewModel() {
    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Loading)
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        checkPermissionsAndNetwork()
    }

    private fun checkPermissionsAndNetwork() {
        viewModelScope.launch {
            if (!permissionManager.hasInternetPermission()) {
                _uiState.value = SplashUiState.NeedsPermission
                return@launch
            }

            val connected = NetworkUtils.hasInternetConnection(context)
            if (connected) {
                _uiState.value = SplashUiState.Success
            } else {
                _uiState.value = SplashUiState.Error("Internet connection required to continue.")
            }
        }
    }
}