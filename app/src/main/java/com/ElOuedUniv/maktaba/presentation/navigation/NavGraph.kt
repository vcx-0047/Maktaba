package com.ElOuedUniv.maktaba.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ElOuedUniv.maktaba.ui.addbook.AddBookScreen
import com.ElOuedUniv.maktaba.ui.bookdetail.BookDetailScreen
import com.ElOuedUniv.maktaba.ui.booklist.BookListScreen
import com.ElOuedUniv.maktaba.ui.category.CategoryExplorerScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.BookList.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.BookList.route) {
            BookListScreen(
                onBookClick = { bookId ->
                    navController.navigate(Screen.BookDetail.createRoute(bookId))
                },
                onAddBookClick = {
                    navController.navigate(Screen.AddBook.route)
                },
                onCategoryClick = {
                    navController.navigate(Screen.CategoryExplorer.route)
                }
            )
        }

        composable(
            route = Screen.BookDetail.route,
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId") ?: return@composable
            BookDetailScreen(
                bookId = bookId,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.CategoryExplorer.route) {
            CategoryExplorerScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.AddBook.route) {
            AddBookScreen(
                onCancel = { navController.popBackStack() },
                onSuccess = { navController.popBackStack() }
            )
        }
    }
}