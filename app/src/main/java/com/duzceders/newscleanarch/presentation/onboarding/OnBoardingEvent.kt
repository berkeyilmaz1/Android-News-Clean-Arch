package com.duzceders.newscleanarch.presentation.onboarding

sealed class OnBoardingEvent {
    data object saveAppEntry : OnBoardingEvent()
}