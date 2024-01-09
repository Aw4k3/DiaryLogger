package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import classes.DiaryEntry
import data.DeleteEntry

@Composable
fun DiaryEntryComponent(diaryEntry: DiaryEntry, navController: NavController) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp, 4.dp)
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(4.dp)
                .wrapContentWidth(Alignment.Start)
            ) {
                Text(
                    diaryEntry.GetTitle(),
                    fontSize = HEADING_FONT_SIZE,
                    fontWeight = FontWeight.Bold
                );
                Text(
                    "You read pages " + diaryEntry.GetStartPageNo() + " to " + diaryEntry.GetEndPageNo(),
                    fontSize = NORMAL_FONT_SIZE
                );
                Text(diaryEntry.GetComments());
            };
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentWidth(Alignment.End)
            ) {
                Button(
                    onClick = { navController.navigate("EntryEditorScreen/".plus(diaryEntry.GetId())) }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = "Edit"
                    );
                }

                Button(
                    onClick = { DeleteEntry(diaryEntry.GetId()) }
                ) {
                    Icon(
                        Icons.Rounded.Delete,
                        contentDescription = "Delete"
                    );
                }
            }
        }
    }
}