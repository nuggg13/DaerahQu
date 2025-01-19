package com.example.daerahqu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(
    private val quizzes: List<Quiz>,
    private val onStartClick: (Quiz) -> Unit
) : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvQuizName: TextView = itemView.findViewById(R.id.tvQuizName)
        private val tvQuizDescription: TextView = itemView.findViewById(R.id.tvQuizDescription)
        private val btnStartQuiz: Button = itemView.findViewById(R.id.btnStartQuiz)

        fun bind(quiz: Quiz) {
            tvQuizName.text = quiz.name
            tvQuizDescription.text = quiz.description
            btnStartQuiz.setOnClickListener { onStartClick(quiz) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quiz, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.bind(quizzes[position])
    }

    override fun getItemCount() = quizzes.size
}
