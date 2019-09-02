package com.github.mag0716.firebase.databasesample

data class Data(
    val id: String = "",
    val createdDatetime: Long,
    val title: String
) {
    fun isTemporaryData() = id.isEmpty()
}