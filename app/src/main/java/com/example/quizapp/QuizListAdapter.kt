package com.example.quizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.data.QuizItem

class QuizListAdapter(
    private val items: List<QuizItem>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<QuizListAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvQuizTitle)
        val tvDesc: TextView = view.findViewById(R.id.tvQuizDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quiz, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val q = items[position]
        holder.tvTitle.text = q.title
        holder.tvDesc.text = q.description
        holder.itemView.setOnClickListener { onClick(q.id) }
    }

    override fun getItemCount(): Int = items.size
}
