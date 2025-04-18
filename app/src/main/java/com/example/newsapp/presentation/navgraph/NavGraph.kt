package com.example.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.OnBoardingScreen
import com.example.newsapp.presentation.OnBoardingViewModel

@Composable
fun NavGraph(startDestination:String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        navigation(route = Route.AppStartNavigation.route,startDestination=Route.OnBoardingScreen.route){
            composable(route = Route.AppStartNavigation.route) {
                val viewmodel= hiltViewModel<OnBoardingViewModel>()
                OnBoardingScreen(event = viewmodel::onEvent)
            }
        }
        navigation(route = Route.NewsNavigation.route, startDestination=Route.HomeScreen.route){
            composable(route = Route.NewsNavigation.route) {

            }
            composable(route = Route.SearchScreen.route) {

            }
            composable(route = Route.NewsNavigation.route) {

            }
            composable(route = Route.NewsNavigation.route) {

            }
        }
    }
}