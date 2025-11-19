package za.co.betway.searchapp.presentation.ui.search

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import za.co.betway.searchapp.presentation.ui.common.DefaultAppScreen

@Composable
fun SearchScreen(viewModel: SearchViewModel = hiltViewModel()) {
    DefaultAppScreen(message = "Search functionality coming soon...")
}