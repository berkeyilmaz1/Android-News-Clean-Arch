package com.duzceders.newscleanarch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.duzceders.newscleanarch.domain.usecases.AppEntryUseCases
import com.duzceders.newscleanarch.presentation.onboarding.OnboardingView
import com.duzceders.newscleanarch.ui.theme.NewsCleanArchTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("test", it.toString())
            }
        }
        setContent {
            NewsCleanArchTheme(
                dynamicColor = false
            ) {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) { OnboardingView() }
            }
        }
    }
}
