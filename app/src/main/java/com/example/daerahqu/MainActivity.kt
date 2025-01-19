package com.example.daerahqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Daftar kuis
        val quizzes = listOf(
            Quiz(
                name = "Kuis Pengetahuan Sriwijaya",
                description = "Berisi soal soal mengenai sejarah sriwijaya",
                questions = listOf(
                    Question("apa itu kerajaan sriwijaya ?", listOf("pemerintahan", "pedesaan", "Kedatuan histori dari sumatra", "klub bola"), 2),
                    Question("kerajaan sriwijaya merupakan kerajaan terbesar dalam bidang?", listOf("maritim", "pertanian", "armada perang", "luas wilayah"), 0),
                    Question("kerajaan sriwijaya terlahir pada abad ke..... masehi", listOf("abad ke 3", "abad ke 5", "abad ke 7", "abad ke 10"), 2),
                    Question("dari mana nama sriwijaya di ambil ?", listOf("dari seorang raja yang bosan", "dari bahasa sansekerta", "perebutan 2 raja", "dari perkawinan sri dan wijaya"), 1),
                    Question("puncak gemilangnya kerajaan sriwijaya bermulai pada abad ?", listOf("2 sampai 3", "3 sampai 4", "8 sampai 9", "20 sampai 21"), 2),
                    Question("Kerajaan Sriwijaya terkenal sebagai pusat pendidikan agama Buddha pada abad ke-7. Apa nama pusat pendidikan di India yang sering dikunjungi oleh para biksu dari Sriwijaya?", listOf("Nalanda", "Taxila", "Varanasi", "Sarnath"), 0),
                    Question("Kerajaan Sriwijaya dikenal sebagai pusat perdagangan internasional. Apa jalur utama perdagangan yang dikuasai Sriwijaya?", listOf("Jalur Sutra Darat", "Jalur Sutra Laut", "Jalur Rempah", "Jalur Kapur Barus"), 1),
                    Question("Apa isi utama Prasasti Talang Tuo?", listOf("Pendirian taman untuk kesejahteraan rakyat", "Kemenangan Sriwijaya atas musuh-musuhnya", "Daftar raja-raja Sriwijaya", "Perjanjian dagang dengan Dinasti Tang"), 0),
                    Question("Apa fungsi utama Prasasti Telaga Batu?", listOf("Sebagai sumpah kesetiaan bagi pejabat kerajaan", "Menjelaskan silsilah raja-raja Sriwijaya", "Menandai wilayah kekuasaan Sriwijaya", "Sebagai penanda perjanjian dagang dengan Tiongkok"), 0),
                    Question("Menurut catatan I-Ching, kota utama Kerajaan Sriwijaya disebut sebagai Shih-li-fo-shih. Nama kota ini dipercaya mengacu pada wilayah mana dalam konteks modern?", listOf("Palembang", "Jambi", "Muara Takus", "Bangka"), 0),

                )
            ),
            Quiz(
                name = "Judul",
                description = "deskripsi",
                questions = listOf(
                    Question("What planet is closest to the sun?", listOf("Mars", "Venus", "Mercury", "Earth"), 2),
                    Question("What is the chemical symbol for water?", listOf("H2O", "O2", "CO2", "HO"), 0)
                )
            )
        )

        // Mengatur RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewQuizzes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = QuizAdapter(quizzes) { quiz ->
            // Pindah ke activity quiz
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("quiz", quiz)
            startActivity(intent)
        }
    }
}
