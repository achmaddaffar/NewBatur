package com.daffa.batur.domain.repository

import com.daffa.batur.data.models.Quiz

interface QuizRepository {

    fun checkAnswer(index: Int, answer: String): Boolean

    fun getQuiz(): List<Quiz>
}