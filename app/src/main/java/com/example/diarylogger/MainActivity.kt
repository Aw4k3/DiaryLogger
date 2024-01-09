package com.example.diarylogger

import Screens.EntryEditorScreen
import Screens.EntryListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import classes.DiaryEntry
import classes.GetEntryById
import classes.NextEntryId
import com.example.diarylogger.ui.theme.DiaryLoggerTheme
import data.sampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContent {
            DiaryLoggerTheme {
                val navController = rememberNavController();
                NavHost(navController = navController, startDestination = "EntryListScreen") {
                    composable(
                        route = "EntryListScreen"
                    ) {
                        EntryListScreen(navController);
                    }

                    composable(
                        route = "EntryEditorScreen/{diaryEntryId}",
                        arguments = listOf(
                            navArgument("diaryEntryId") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        var id = backStackEntry.arguments?.getInt("diaryEntryId");
                        if (id != null)
                            EntryEditorScreen(navController, diaryEntry = GetEntryById(id));
                        else
                            EntryEditorScreen(navController, diaryEntry = DiaryEntry(NextEntryId(sampleData), 0, "New Book", 0, 0, "No comments"));
                    }
                }
            }
        }
    }
}
