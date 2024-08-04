package com.raeanandres.thalesexam.model

sealed class TaskType {
    data object AddProduct : TaskType()
    data object EditProduct : TaskType()
}