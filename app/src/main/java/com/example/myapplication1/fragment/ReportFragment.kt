package com.example.myapplication1.fragment

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.fragment_report.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ReportFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val urlPort = ":8085"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestPermissions()
        downloadReportsOnTap()
    }

    private fun downloadReportsOnTap() {
        reportsTextViewMajors.setOnClickListener {
            downloadReport("Majors")
        }
        reportsTextViewClasses.setOnClickListener {
            downloadReport("Classes")
        }
        reportsTextViewTeachers.setOnClickListener {
            downloadReport("Teachers")
        }
        reportsTextViewYear.setOnClickListener {
            downloadReport("GradesByYears")
        }
        reportsTextViewMutual.setOnClickListener {
            downloadReport("MutualClasses")
        }
    }

    private fun downloadReport(reportName: String) {
        val reportUrlString =
            getString(R.string.urlReportBase) + urlPort + getString(R.string.urlReportBody) +
                    reportName + getString(R.string.urlReportOptions)

        val intentWebBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(reportUrlString))
        startActivity(intentWebBrowser)
    }

    private fun requestPermissions() {
        val requestCode = 1
        activity?.let {
            ActivityCompat.requestPermissions(
                it, arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), requestCode
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

}