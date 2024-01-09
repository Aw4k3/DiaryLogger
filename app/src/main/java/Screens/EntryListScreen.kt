package Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import classes.DiaryEntry
import components.DiaryEntryComponent
import components.NORMAL_FONT_SIZE
import components.TITLE_FONT_SIZE
import data.sampleData

@Composable
fun EntryListScreen(navController: NavController) {
    Surface(
        Modifier
            .fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(
                    "Diary Logger",
                    fontSize = TITLE_FONT_SIZE,
                    modifier = Modifier
                        .align(Alignment.Center)
                );
            }
            LazyColumn {
                if (sampleData.size > 0)
                    items(sampleData) { entry: DiaryEntry -> DiaryEntryComponent(entry, navController) };
                else
                    item {
                        Box(
                            modifier = Modifier
                                .fillParentMaxSize()
                        ) {
                            Text(
                                text = "Click \"New Entry\" to begin",
                                modifier = Modifier
                                    .align(Alignment.Center)
                            );
                        }
                    }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ExtendedFloatingActionButton (
                onClick = { navController.navigate("EntryEditorScreen/null") },
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    Icons.Rounded.Add,
                    "New Entry"
                );
                Text(
                    text = "New Entry",
                    fontSize = NORMAL_FONT_SIZE
                );
            }
        }
    }
}