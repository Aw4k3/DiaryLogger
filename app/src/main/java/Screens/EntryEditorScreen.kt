package Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import classes.DiaryEntry
import data.AddEntry
import data.UpdateEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryEditorScreen(navController: NavController, diaryEntry: DiaryEntry, updateEntry: Boolean) {
    var _diaryEntry = diaryEntry;

    var title by remember { mutableStateOf(_diaryEntry.GetTitle()) };
    var comments by remember { mutableStateOf(_diaryEntry.GetComments()) };
    var startNo by remember { mutableIntStateOf(_diaryEntry.GetStartPageNo()) };
    var endNo by remember { mutableIntStateOf(_diaryEntry.GetEndPageNo()) };
    var datePickerState = rememberDatePickerState(_diaryEntry.GetTimestamp());

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                label = { Text("Title") },
                value = title,
                onValueChange = { text -> title = text },
                maxLines = 1
            );

            OutlinedTextField(
                label = { Text("Comments") },
                value = comments,
                onValueChange = { text -> comments = text }
            );

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    OutlinedTextField(
                        label = { Text("Start Page No.") },
                        value = startNo.toString(),
                        onValueChange = { text -> startNo = text.toInt(); },
                        maxLines = 1
                    );
                }

                Column(
                    Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    OutlinedTextField(
                        label = { Text("End Page No.") },
                        value = endNo.toString(),
                        onValueChange = { text -> endNo = text.toInt(); },
                        maxLines = 1
                    );
                }
            }

            DatePicker(datePickerState);

            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.spacedBy(8.dp),
            ) {
                OutlinedButton(
                    onClick = { navController.navigate("EntryListScreen") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel");
                }

                Button(
                    onClick = {
                        _diaryEntry.SetTitle(title);
                        _diaryEntry.SetComments(comments);
                        _diaryEntry.SetStartPageNo(startNo)
                        _diaryEntry.SetEndPageNo(endNo);
                        _diaryEntry.SetTimestamp(datePickerState.selectedDateMillis!!);
                        if (updateEntry)
                            UpdateEntry(_diaryEntry.GetId(), _diaryEntry)
                        else
                            AddEntry(_diaryEntry);
                        navController.navigate("EntryListScreen");
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Save");
                }
            }
        }
    }
}