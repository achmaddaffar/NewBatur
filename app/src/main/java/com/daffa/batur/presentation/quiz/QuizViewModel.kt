package com.daffa.batur.presentation.quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.batur.data.repository.QuizRepositoryImpl

class QuizViewModel(
    private val quizRepository: QuizRepositoryImpl
) : ViewModel() {

    private val _health = mutableStateOf<Int>(3)
    val health: State<Int> = _health

    fun decreaseHealth() {
        _health.value--
    }

    fun getQuiz() = quizRepository.getQuiz()

    fun checkAnswer(index: Int, answer: String) = quizRepository.checkAnswer(index, answer)
}