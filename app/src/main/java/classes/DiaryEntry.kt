package classes

import data.sampleData

class DiaryEntry {
    private var id: Int = -1;
    private var timestamp: Long? = 0;
    private var title: String = "";
    private var startPageNo: Int = 0;
    private var endPageNo: Int = 0;
    private var comments: String = "";

    constructor(id: Int, timestamp: Long, title: String, startPageNo: Int, endPageNo: Int, comments: String) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.startPageNo = startPageNo;
        this.endPageNo = endPageNo;
        this.comments = comments;
    }

    fun GetId(): Int {
        return this.id;
    }

    fun GetTimestamp(): Long? {
        return timestamp;
    }

    fun SetTimestamp(epochTime: Long?) {
        this.timestamp = epochTime;
    }

    fun GetTitle(): String {
        return this.title;
    }

    fun SetTitle(title: String) {
        this.title = title.trim();
    }

    fun GetStartPageNo(): Int {
        return this.startPageNo;
    }

    fun SetStartPageNo(pageNo: Int) {
        if (pageNo > 0) this.startPageNo = pageNo;
    }

    fun GetEndPageNo(): Int {
        return this.endPageNo;
    }

    fun SetEndPageNo(pageNo: Int) {
        if (pageNo > 0) this.endPageNo = pageNo;
    }

    fun GetComments(): String {
        return this.comments;
    }

    fun SetComments(comments: String) {
        this.comments = comments.trim();
    }
}

fun NextEntryId(dataset: List<DiaryEntry>): Int {
    var id: Int = 0;
    for (item in dataset) if (item.GetId() > id) id = item.GetId();
    return ++id;
}

fun GetEntryById(id: Int): DiaryEntry {
    return sampleData[id];
}