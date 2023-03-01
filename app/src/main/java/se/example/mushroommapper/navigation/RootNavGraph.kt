package se.example.mushroommapper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import se.example.mushroommapper.view.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        NavigationGraph(navController = navController)
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
    const val MAP = "map_graph"
    const val SIGN_UP = "SignUp_Screen"
    const val LOGIN = "SignIn_Screen"
}