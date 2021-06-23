package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.Student
import kotlinx.android.synthetic.main.row_list_student.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class StudentRecyclerViewAdapter :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentViewHolder>() {

    var studentList = mutableListOf<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_list_student, parent, false)
        return StudentViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewStudentName = view.textViewStudentName
        private val textViewStudentJMBAG = view.textViewStudentJMBAG
        private val textViewStudentOIB = view.textViewStudentOIB
        private val textViewStudentDOB = view.textViewStudentDOB
        private val textViewStudentDateEnroll = view.textViewStudentDateOfEnroll
        private val textViewStudentEmail = view.textViewStudentEmail
        private val textViewStudentAddress = view.textViewStudentAddress

        fun bind(data: Student) {
            val dateStringDOB = getDateFromString(data.dateOfBirth)
            val dateStringEnroll = getDateFromString(data.dateOfEnrollment)

            textViewStudentName.text = data.firstName + " " + data.lastName
            textViewStudentJMBAG.text = data.jMBAG
            textViewStudentOIB.text = "OIB: " + data.oIB
            textViewStudentDOB.text = "Date of birth: " + dateStringDOB
            textViewStudentDateEnroll.text = "Date of enrollment: " + dateStringEnroll
            textViewStudentEmail.text = data.email
            textViewStudentAddress.text = data.address
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