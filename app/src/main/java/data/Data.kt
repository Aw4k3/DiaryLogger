package data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import classes.DiaryEntry

var sampleData: SnapshotStateList<DiaryEntry> = mutableStateListOf(
    DiaryEntry(0, 1703533553000, "Jujutsu Kasisen", 1, 10, "very good very nice"),
    DiaryEntry(1, 1686771953000, "The Seven Deadly Sins", 5, 8, "They ruined the anime for it in S3"),
    DiaryEntry(2, 1677008753000, "Jojo's Bizarre Adventures", 15, 23, "Another banger")
);

fun AddEntry(diaryEntry: DiaryEntry) {
    sampleData.add(diaryEntry);
    ResetIds(sampleData);
}

fun DeleteEntry(id: Int) {
    sampleData.removeAt(id);
    ResetIds(sampleData);
}

fun UpdateEntry(id: Int, diaryEntry: DiaryEntry) {
    sampleData[id] = diaryEntry;
    ResetIds(sampleData);
}

fun NextEntryId(dataset: List<DiaryEntry>): Int {
    if (dataset.isEmpty()) return 0;
    var id: Int = 0;
    for (item in dataset) if (item.GetId() > id) id = item.GetId();
    return ++id;
}

fun GetEntryById(id: Int): DiaryEntry {
    return sampleData[id];
}

// Unfucks any broken ids that causes crashing >:D
fun ResetIds(dataset: List<DiaryEntry>) {
    var i: Int = 0;
    while (i < dataset.size) dataset[i].SetId(i++);
}