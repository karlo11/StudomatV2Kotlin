package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.Major
import kotlinx.android.synthetic.main.row_list_major.view.*

class MajorRecyclerViewAdapter :
    RecyclerView.Adapter<MajorRecyclerViewAdapter.MajorViewHolder>() {

    var majorList = mutableListOf<Major>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_major, parent, false)
        return MajorViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MajorViewHolder, position: Int) {
        holder.bind(majorList[position])
    }

    override fun getItemCount(): Int {
        return majorList.size
    }

    class MajorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewMajorName = view.textViewMajorName
        private val textViewMajorAbv = view.textViewMajorAbv
        private val textViewMajorDeanName = view.textViewMajorDeanName

        fun bind(data: Major) {
            textViewMajorName.text = data.name
            textViewMajorAbv.text = data.nameAbbreviation
            textViewMajorDeanName.text =
                "Vice Dean: " + data.viceDeanFirstName + " " + data.viceDeanLastName
        }
    }
}