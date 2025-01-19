package com.example.daerahqu

import java.io.Serializable

data class Quiz(
    val name: String,
    val description: String,
    val questions: List<Question>
) : Serializable

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) : Serializable
