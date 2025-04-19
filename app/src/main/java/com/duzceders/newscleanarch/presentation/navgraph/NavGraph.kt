package com.duzceders.newscleanarch.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.duzceders.newscleanarch.presentation.onboarding.OnBoardingViewModel
import com.duzceders.newscleanarch.presentation.onboarding.OnboardingView

@Composable
fun NavGraph(startDestination: String){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(startDestination = Route.OnboardingView.route, route = Route.AppStartNavigation.route) {
            composable(Route.OnboardingView.route) {
                val viewModel:OnBoardingViewModel= hiltViewModel()
                OnboardingView(event = viewModel::onEvent)
            }
        }

        navigation(route = Route.NewsNavigation.route, startDestination = Route.NewsNavigatorView.route) {
            composable(Route.NewsNavigatorView.route) {
                Text(text = "News Navigator View")
            }
        }
    }

}