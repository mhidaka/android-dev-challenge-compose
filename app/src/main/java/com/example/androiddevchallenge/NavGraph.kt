/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.CAT_DETAIL_ID_KEY
import com.example.androiddevchallenge.repository.post3
import com.example.androiddevchallenge.repository.posts
import com.example.androiddevchallenge.ui.detail.Detail
import com.example.androiddevchallenge.ui.listing.Listing

object MainDestinations {
    const val MAIN_ROUTE = "main"
    const val CAT_DETAIL_ROUTE = "details"
    const val CAT_DETAIL_ID_KEY = "catId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.MAIN_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.MAIN_ROUTE) {
            Listing(
                featuredCat = post3,
                cats = posts,
                onSelected = actions.selectCat
            )
        }
        composable(
            "${MainDestinations.CAT_DETAIL_ROUTE}/{$CAT_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(CAT_DETAIL_ID_KEY) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val catId = arguments.getString(CAT_DETAIL_ID_KEY, "")
            Detail(
                catId = catId,
                onUpPress = actions.upPress
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectCat: (String) -> Unit = { catId: String ->
        navController.navigate("${MainDestinations.CAT_DETAIL_ROUTE}/$catId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
