package com.daffa.batur.data

import com.daffa.batur.R
import com.daffa.batur.data.models.Quiz
import com.daffa.batur.presentation.util.states.SelectionOption

object DataDummy {

    val quiz = listOf(
        Quiz(
            question = "Manakah di bawah ini yang termasuk tarian daerah Sunda?",
            options = listOf(
                SelectionOption("Wayang", false),
                SelectionOption("Piring", false),
                SelectionOption("Kecak", false),
                SelectionOption("Saman", false),
                SelectionOption("Topeng", false),
            ),
            answer = listOf(
                "Wayang"
            )
        ),
        Quiz(
            question = "Tarian Wayang berasal dari",
            options = listOf(
                SelectionOption("Cirebon", false),
                SelectionOption("Bandung", false),
                SelectionOption("Bali", false),
                SelectionOption("Garut", false),
                SelectionOption("Subang", false)
            ),
            answer = listOf(
                "Cirebon"
            ),
            image = R.drawable.tari_wayang
        ),
    )
}