package com.ElOuedUniv.maktaba.data.model

data class Book(
    val id: Int,
    val title: String,
    val isbn: String,
    val pages: Int,
    val currentPage: Int = 0,
    val status: ReadingStatus = ReadingStatus.NOT_STARTED,
    val imageUrl: String? = null,
    val categoryId: Int? = null
)

enum class ReadingStatus(val label: String) {
    NOT_STARTED("Not Started"),
    READING("Reading"),
    FINISHED("Finished")
}