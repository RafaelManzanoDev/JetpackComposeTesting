package com.rafaelmanzano.jetpackcomposecomponents.ui

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckChange: (Boolean) -> Unit
)
