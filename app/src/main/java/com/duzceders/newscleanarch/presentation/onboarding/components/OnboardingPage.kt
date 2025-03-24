package com.duzceders.newscleanarch.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.duzceders.newscleanarch.R
import com.duzceders.newscleanarch.presentation.onboarding.OnboardPage
import com.duzceders.newscleanarch.presentation.onboarding.onboardPages
import com.duzceders.newscleanarch.ui.theme.NewsCleanArchTheme


@Composable
fun OnboardingPage(onboardPage: OnboardPage, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            modifier = modifier
                .fillMaxWidth(),
            painter = painterResource(id = onboardPage.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.medium)))
        Text(
            text = onboardPage.title,
            modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.large)),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)

        )
        Text(
            text = onboardPage.description,
            modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.large)),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)

        )

    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingViewPreview() {
    NewsCleanArchTheme {
        OnboardingPage(
            onboardPage = onboardPages[0]
        )
    }
}
