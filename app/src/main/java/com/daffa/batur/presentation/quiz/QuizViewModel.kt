package com.daffa.batur.presentation.quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.batur.data.models.Quiz
import com.daffa.batur.data.repository.QuizRepositoryImpl
import com.daffa.batur.presentation.util.states.SelectionOption
import com.daffa.batur.util.Constants.Empty
import timber.log.Timber

class QuizViewModel(
    private val quizRepository: QuizRepositoryImpl,
) : ViewModel() {

    private val _health = mutableStateOf(3)
    val health: State<Int> = _health

    val quiz = quizRepository.getQuiz()

    private val _currentQuiz = mutableStateOf(
        Quiz(
            question = String.Empty,
            options = listOf(),
            answer = listOf()
        )
    )
    private val currentQuiz: State<Quiz> = _currentQuiz

    private val _quizOptions = currentQuiz.value.options
    var selectedQuizOption = String.Empty

    fun decreaseHealth() {
        _health.value--
    }

    fun setCurrentQuiz(quiz: Quiz) {
        _currentQuiz.value = quiz
    }

    fun selectionOptionSelected(selectionOption: SelectionOption) {
        _quizOptions.forEach { it.selected = false }
        val currentOption = _quizOptions.find { it.option == selectionOption.option }
        currentOption?.selected = true
        selectedQuizOption = selectionOption.option
        Timber.d("CEK JAWABAN $selectedQuizOption")
    }

    fun checkAnswer(index: Int, answer: String) = quizRepository.checkAnswer(index, answer)
}