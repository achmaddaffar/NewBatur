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

    var selectedQuizOption = String.Empty

    fun decreaseHealth() {
        _health.value--
    }

    fun selectionOptionSelected(index: Int, selectionOption: SelectionOption) {
        val currentQuiz = quiz[index]
        val currentQuizOptions = currentQuiz.options
        currentQuizOptions.forEach { it.selected = false }
        val currentOption = currentQuizOptions.find { it.option == selectionOption.option }
        currentOption?.selected = true
        selectedQuizOption = selectionOption.option
        Timber.e("CEK JAWABAN $selectedQuizOption")
        Timber.e("CEK KEBENARAN ${currentOption?.selected}")
        Timber.e("CEK ISI LIST QUIZ ${currentQuizOptions.size}")
    }

    fun checkAnswer(index: Int, answer: String) = quizRepository.checkAnswer(index, answer)
}