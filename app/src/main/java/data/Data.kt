package data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import classes.DiaryEntry

var sampleData: SnapshotStateList<DiaryEntry> = mutableStateListOf(
    DiaryEntry(0, 0, "Jujutsu Kasisen", 1, 10, "very good very nice"),
    DiaryEntry(1, 0, "The Seven Deadly Sins", 5, 8, "They ruined the anime for it in S3"),
    DiaryEntry(2, 0, "Jojo's Bizarre Adventures", 15, 23, "Another banger")
);

fun AddEntry(diaryEntry: DiaryEntry) {
    sampleData.add(diaryEntry);
}

fun DeleteEntry(id: Int) {
    sampleData.removeAt(id);
}

fun EditEntry(id: Int) {

}