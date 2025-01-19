package com.example.daerahqu

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbOption1: RadioButton
    private lateinit var rbOption2: RadioButton
    private lateinit var rbOption3: RadioButton
    private lateinit var rbOption4: RadioButton
    private lateinit var btnNext: Button

    private lateinit var quiz: Quiz
    private var currentQuestionIndex = 0
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Inisialisasi view
        tvQuestion = findViewById(R.id.tvQuestion)
        rgOptions = findViewById(R.id.rgOptions)
        rbOption1 = findViewById(R.id.rbOption1)
        rbOption2 = findViewById(R.id.rbOption2)
        rbOption3 = findViewById(R.id.rbOption3)
        rbOption4 = findViewById(R.id.rbOption4)
        btnNext = findViewById(R.id.btnNext)

        // Ambil data kuis dari intent
        quiz = intent.getSerializableExtra("quiz") as Quiz

        // Tampilkan pertanyaan pertama
        showQuestion()

        // Tombol Next untuk pindah ke pertanyaan berikutnya
        btnNext.setOnClickListener {
            checkAnswer()
            if (currentQuestionIndex < quiz.questions.size - 1) {
                currentQuestionIndex++
                showQuestion()
            } else {
                showResult()
            }
        }
    }

    private fun showQuestion() {
        // Ambil pertanyaan saat ini
        val question = quiz.questions[currentQuestionIndex]

        // Tampilkan pertanyaan dan opsi
        tvQuestion.text = question.questionText
        rbOption1.text = question.options[0]
        rbOption2.text = question.options[1]
        rbOption3.text = question.options[2]
        rbOption4.text = question.options[3]

        // Reset pilihan jawaban
        rgOptions.clearCheck()
    }

    private fun checkAnswer() {
        val question = quiz.questions[currentQuestionIndex]

        // Cek apakah jawaban yang dipilih benar
        val selectedOptionIndex = when (rgOptions.checkedRadioButtonId) {
            R.id.rbOption1 -> 0
            R.id.rbOption2 -> 1
            R.id.rbOption3 -> 2
            R.id.rbOption4 -> 3
            else -> -1
        }

        if (selectedOptionIndex == question.correctAnswerIndex) {
            correctAnswers++
        }
    }

    private fun showResult() {
        // Tampilkan hasil kuis
        val resultMessage = "You got $correctAnswers out of ${quiz.questions.size} correct!"
        tvQuestion.text = resultMessage
        rgOptions.visibility = RadioGroup.GONE
        btnNext.text = "Finish"
        btnNext.setOnClickListener {
            finish() // Kembali ke MainActivity
        }
    }
}
