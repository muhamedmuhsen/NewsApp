package com.example.newsapp.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.usecases.appentry.ReadAppEntry
import com.example.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appEntry: ReadAppEntry
) : ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntry().onEach { shouldStartFromHomeScreen->

            if (shouldStartFromHomeScreen)
                startDestination = Route.HomeScreen.route
            else
                startDestination = Route.AppStartNavigation.route

            splashCondition = false

        }
    }
}
