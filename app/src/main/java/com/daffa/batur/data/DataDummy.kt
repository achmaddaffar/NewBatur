package com.daffa.batur.data

import com.daffa.batur.R
import com.daffa.batur.data.models.Quiz

object DataDummy {

    val quiz = listOf(
        Quiz(
            question = "Manakah di bawah ini yang termasuk tarian daerah Sunda?",
            options = listOf(
                "Wayang",
                "Piring",
                "Kecak",
                "Saman",
                "Topeng"
            ),
            answer = listOf(
                "Wayang"
            )
        ),
        Quiz(
            question = "Tarian Wayang berasal dari",
            options = listOf(
                "Cirebon",
                "Bandung",
                "Bali",
                "Garut",
                "Subang"
            ),
            answer = listOf(
                "Cirebon"
            ),
            image = R.drawable.tari_wayang
        ),
    )
}