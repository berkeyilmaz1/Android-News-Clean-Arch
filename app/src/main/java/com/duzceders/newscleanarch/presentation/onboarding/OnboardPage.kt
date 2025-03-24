package com.duzceders.newscleanarch.presentation.onboarding

import androidx.annotation.DrawableRes

data class OnboardPage(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val onboardPages = listOf(
    OnboardPage(
        title = "Welcome to News",
        description = "Get the latest news from all over the world",
        image = com.duzceders.newscleanarch.R.drawable.onboarding1
    ),
    OnboardPage(
        title = "Breaking News",
        description = "Get the latest breaking news from all over the world",
        image = com.duzceders.newscleanarch.R.drawable.onboarding2
    ),
    OnboardPage(
        title = "Stay Updated",
        description = "Stay updated with the latest news",
        image = com.duzceders.newscleanarch.R.drawable.onboarding3
    )
)
