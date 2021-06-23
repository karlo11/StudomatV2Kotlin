package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.Class
import com.example.myapplication1.model.College
import kotlinx.android.synthetic.main.row_list_class.view.*
import kotlinx.android.synthetic.main.row_list_college.view.*

class ClassRecyclerViewAdapter :
    RecyclerView.Adapter<ClassRecyclerViewAdapter.ClassViewHolder>() {

    var classList = mutableListOf<Class>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_class, parent, false)
        return ClassViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bind(classList[position])
    }

    override fun getItemCount(): Int {
        return classList.size
    }

    class ClassViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewClassName = view.textViewClassName
        private val textViewClassDetails = view.textViewClassDetails
        private val textViewClassECTS = view.textViewClassECTS
        private val textViewClassHours = view.textViewClassHours
        private val textViewClassISVU = view.textViewClassISVU
        private val textViewClassSemester = view.textViewClassSemester

        fun bind(data: Class) {
            textViewClassName.text = data.name
            textViewClassDetails.text = data.details
            textViewClassECTS.text = data.numberOfECTS.toString() + " ECTS"
            textViewClassHours.text = "Hours of work: " +
                    (data.hoursOfAudit + data.hoursOfConstr + data.hoursOfHomework
                            + data.hoursOfLab + data.hoursOfLectures + data.hoursOfSeminar)
                        .toString()
            textViewClassISVU.text = "ISVU: " + data.iSVUNumber
            textViewClassSemester.text = data.semester.toString() + ". semester"
        }
    }
}