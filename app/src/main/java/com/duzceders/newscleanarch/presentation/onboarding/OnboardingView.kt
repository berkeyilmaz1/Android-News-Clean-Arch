package com.duzceders.newscleanarch.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.duzceders.newscleanarch.R
import com.duzceders.newscleanarch.presentation.common.NewsButton
import com.duzceders.newscleanarch.presentation.common.NewsTextButton
import com.duzceders.newscleanarch.presentation.onboarding.components.OnboardingPage
import com.duzceders.newscleanarch.presentation.onboarding.components.PageIndicator
import com.duzceders.newscleanarch.presentation.onboarding.model.onboardPages
import kotlinx.coroutines.launch

@Composable
fun OnboardingView(event: (OnBoardingEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            onboardPages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnboardingPage(onboardPage = onboardPages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.medium))
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(dimensionResource(R.dimen.indicator_widht)),
                pageCount = onboardPages.size,
                currentPage = pagerState.currentPage,

                )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(title = buttonState.value[0], onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }

                    })

                }
                NewsButton(
                    title = buttonState.value[1],
                ) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            event(OnBoardingEvent.saveAppEntry)

                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}
