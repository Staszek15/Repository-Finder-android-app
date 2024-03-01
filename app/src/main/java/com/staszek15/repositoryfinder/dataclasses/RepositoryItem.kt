package com.staszek15.repositoryfinder.dataclasses

data class RepositoryItem(
    val repository: String,
    val owner: String,
    val branch: String,
    val sha: String
)
