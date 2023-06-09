package com.daffa.batur.presentation.onboarding.screen.fourth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.R
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.states.SelectionOption
import com.daffa.batur.util.Constants.Empty
import kotlinx.coroutines.launch

class FourthOnBoardingViewModel(
    private val repository: UserRepositoryImpl
) : ViewModel() {

    val user = repository.readUser()

    private val _countryOptions = listOf(
        SelectionOption("Indonesia", false, R.drawable.flag_indonesia)
    )

    val countryOptions: List<SelectionOption>
        get() = _countryOptions

    private val _options = listOf(
        SelectionOption("Suku Jawa", false),
        SelectionOption("Suku Sunda", false),
        SelectionOption("Suku Betawi", false),
        SelectionOption("Suku Madura", false),
        SelectionOption("Suku Tengger", false),
    )

    private var selectedSuku = String.Empty

    val options: List<SelectionOption>
        get() = _options

    private var countryOptionsSelected by mutableStateOf(false)
    private var optionsSelected by mutableStateOf(false)

    fun selectionCountryOptionSelected(selectionOption: SelectionOption) {
        _countryOptions.forEach { it.selected = false }
        _countryOptions.find { it.option == selectionOption.option }?.selected = true
        countryOptionsSelected = true
    }

    fun selectionOptionSelected(selectionOption: SelectionOption) {
        _options.forEach { it.selected = false }
        _options.find { it.option == selectionOption.option }?.selected = true
        optionsSelected = true
        selectedSuku = selectionOption.option
    }

    fun checkOptionsSelected(): Boolean = countryOptionsSelected && optionsSelected

    fun saveSuku() = viewModelScope.launch {
        repository.saveSuku(selectedSuku)
    }
}