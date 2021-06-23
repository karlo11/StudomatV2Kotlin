package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.Teacher
import kotlinx.android.synthetic.main.row_list_teacher.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.TeacherViewHolder>() {

    var teacherList = mutableListOf<Teacher>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeacherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_teacher, parent, false)
        return TeacherViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teacherList[position])
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    class TeacherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewTeacherName = view.textViewTeacherName
        private val textViewTeacherOIB = view.textViewTeacherOIB
        private val textViewTeacherTitle = view.textViewTeacherTitle
        private val textViewTeacherAddress = view.textViewTeacherAddress
        private val textViewTeacherEmail = view.textViewTeacherEmail
        private val textViewTeacherDOB = view.textViewTeacherDOB

        fun bind(data: Teacher) {
            val dateStringDOB = getDateFromString(data.dateOfBirth)

            textViewTeacherName.text = data.firstName + " " + data.lastName
            textViewTeacherOIB.text = data.oIB
            textViewTeacherTitle.text = data.title
            textViewTeacherAddress.text = data.address as CharSequence?
            textViewTeacherEmail.text = data.email
            textViewTeacherDOB.text = "Date of birth: " + dateStringDOB
        }

        private fun getDateFromString(data: String): String {
            val stringDateInput = data.substring(0, 10)
            val dateInputFormat: DateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            val dateOutputFormat: DateTimeFormatter =
                DateTimeFormatter.ofPattern("dd.MM.yyyy.", Locale.ENGLISH);
            val dateLocal: LocalDate = LocalDate.parse(stringDateInput, dateInputFormat)

            return dateOutputFormat.format(dateLocal)
        }
    }
}