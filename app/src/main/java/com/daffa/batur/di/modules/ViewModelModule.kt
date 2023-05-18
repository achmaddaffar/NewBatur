package com.daffa.batur.di.modules

import com.daffa.batur.presentation.home.HomeViewModel
import com.daffa.batur.presentation.login.LoginViewModel
import com.daffa.batur.presentation.onboarding.screen.fourth.FourthOnBoardingViewModel
import com.daffa.batur.presentation.onboarding.screen.third.ThirdOnBoardingViewModel
import com.daffa.batur.presentation.quiz.QuizViewModel
import com.daffa.batur.presentation.register.RegisterViewModel
import com.daffa.batur.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { RegisterViewModel(get(), get()) }
    viewModel { ThirdOnBoardingViewModel(get()) }
    viewModel { FourthOnBoardingViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { QuizViewModel(get()) }
}