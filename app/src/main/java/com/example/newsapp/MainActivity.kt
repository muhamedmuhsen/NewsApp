package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.domain.usecases.ReadAppEntry
import com.example.newsapp.presentation.OnBoardingScreen
import com.example.newsapp.presentation.OnBoardingViewModel
import com.example.newsapp.presentation.navgraph.NavGraph
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            viewModel.splashCondition
        }


        setContent {
            NewsAppTheme {
                Box(Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination)
                }
            }
        }
    }
}



