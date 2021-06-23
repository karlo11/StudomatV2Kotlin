package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.College
import kotlinx.android.synthetic.main.row_list_college.view.*

class CollegeRecyclerViewAdapter :
    RecyclerView.Adapter<CollegeRecyclerViewAdapter.CollegeViewHolder>() {

    var collegeList = mutableListOf<College>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_college, parent, false)
        return CollegeViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        holder.bind(collegeList[position])
    }

    override fun getItemCount(): Int {
        return collegeList.size
    }

    class CollegeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewCollegeName = view.textViewCollegeName
        private val textViewCollegeAddress = view.textViewCollegeAddress
        private val textViewCollegeYear = view.textViewCollegeYear
        private val textViewCollegeDean = view.textViewCollegeDean

        fun bind(data: College) {
            textViewCollegeName.text = data.name
            textViewCollegeAddress.text = data.address
            textViewCollegeYear.text = data.foundationYear.toString()
            textViewCollegeDean.text = "Dean: " + data.deanFirstName + " " + data.deanLastName
        }
    }
}