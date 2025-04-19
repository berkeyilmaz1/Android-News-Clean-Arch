package com.duzceders.newscleanarch.presentation.navgraph

sealed class Route(val route: String) {

    data object OnboardingView : Route("onboardingView")
    data object HomeView : Route("homeView")
    data object SearchView : Route("searchView")
    data object DetailView : Route("detailView")
    data object BookmarkView : Route("bookmarkView")
    data object AppStartNavigation : Route("appStartNavigation")
    data object NewsNavigation : Route("newsNavigation")
    data object NewsNavigatorView: Route("newsNavigatorView")
}