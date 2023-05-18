package com.daffa.batur.data.repository

import com.daffa.batur.data.DataDummy
import com.daffa.batur.domain.repository.QuizRepository

class QuizRepositoryImpl: QuizRepository {

    private val quiz = DataDummy.quiz

    override fun checkAnswer(index: Int, answer: String): Boolean {
        return quiz[index].answer.contains(answer)
    }

    override fun getQuiz() = quiz
}