package com.daffa.batur.data

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
            imageUrl = "https://i0.wp.com/www.romadecade.org/wp-content/uploads/2022/06/Tari-Wayang-Populer.jpeg?resize=800%2C533&ssl=1"
        ),
        Quiz(
            question = "Suku Sunda merupakan suku yang berasal dari jawa barat dan terbagi menjadi dua, yaitu Sunda Banten dan ...",
            options = listOf(
                SelectionOption("Sunda Mori", false),
                SelectionOption("Sunda Priangan", false),
                SelectionOption("Sunda Mandailing", false),
                SelectionOption("Sunda Batak", false),
                SelectionOption("Sanda Jawa", false)
            ),
            answer = listOf(
                "Sunda Priangan"
            )
        ),
        Quiz(
            question = "Berikut adalah beberapa ungkapan dalam bahasa sunda, manakah yang memiliki arti “hidup harus rukun saling menyayangi, tidak pernah berselisih”",
            options = listOf(
                SelectionOption("Ulah marebutkeun balung tanpa eusi", false),
                SelectionOption("Kawas gula eujeung peueut", false),
                SelectionOption("Ulah ngaliarkeun taleus ateul", false),
                SelectionOption("Ulah nyolok panon buncelik", false),
                SelectionOption("Buruk-buruk papan jati", false)
            ),
            answer = listOf(
                "Kawas gula eujeung peueut"
            )
        ),
        Quiz(
            question = "Seni teater yang terkenal dalam tanah pasundan adalah kesenian ...",
            options = listOf(
                SelectionOption("Opera", false),
                SelectionOption("Burlesque", false),
                SelectionOption("Vaudeville", false),
                SelectionOption("Wayang Golek", false),
                SelectionOption("Paduan Suara", false)
            ),
            answer = listOf(
                "Wayang Golek"
            )
        ),
        Quiz(
            question = "Senjata tradisional suku Betawi yang bersarungkan dari kayu adalah ...",
            options = listOf(
                SelectionOption("Katana", false),
                SelectionOption("Parang", false),
                SelectionOption("Bendo", false),
                SelectionOption("Panci", false),
                SelectionOption("Celurit", false)
            ),
            answer = listOf(
                "Bendo"
            ),
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Golok_naga_indonesia.jpg/640px-Golok_naga_indonesia.jpg"
        ),
        Quiz(
            question = "Rumah tradisional/adat Betawi adalah",
            options = listOf(
                SelectionOption("Krong Bade", false),
                SelectionOption("Bolon", false),
                SelectionOption("Gadang", false),
                SelectionOption("Bubungan Lima", false),
                SelectionOption("Rumah Kebaya", false)
            ),
            answer = listOf(
                "Rumah Kebaya"
            ),
            imageUrl = "https://asset.kompas.com/crops/AA191ERBIIeIcvxZDmpgyDS9PsU=/0x0:512x341/750x500/data/photo/2021/01/28/6012bbbae02b0.jpg"
        ),
    )
}