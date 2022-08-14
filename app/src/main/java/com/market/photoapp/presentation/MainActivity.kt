package com.market.photoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.market.photoapp.presentation.FirstScreen.FirstScreenViewModel
import com.market.photoapp.ui.theme.PhotoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoAppTheme() {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.FirstScreen.route,
                        ) {
                        composable(route = Screens.FirstScreen.route) {
                            FirstScreen(navController = navController)
                        }
                        composable(route = Screens.ListScreen.route +
                            "?numberLimit={numberLimit}&firstPhoto={firstPhoto}&secondPhoto={secondPhoto}",
                            arguments = listOf(
                                navArgument(
                                    name = "numberLimit"
                                ) {
                                  type = NavType.IntType
                                },
                                navArgument(
                                    name = "firstPhoto"
                                ) {},
                                navArgument(
                                    name = "secondPhoto"
                                ) {},
                            )
                        ) {
                            ListScreen(
                                //navController = navController,
                                numberLimit = it.arguments?.getInt("numberLimit")!!,
                                firstPhoto = it.arguments?.getString("firstPhoto")!!,
                                secondPhoto = it.arguments?.getString("secondPhoto")!!,
                            )
                        }
                    }
                }
            }
        }
    }
}



