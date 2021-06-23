package com.example.myapplication1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1.R
import com.example.myapplication1.adapter.ClassRecyclerViewAdapter
import com.example.myapplication1.adapter.CollegeRecyclerViewAdapter
import com.example.myapplication1.model.ClassList
import com.example.myapplication1.model.CollegeList
import com.example.myapplication1.viewModel.ClassViewModel
import com.example.myapplication1.viewModel.CollegeViewModel
import kotlinx.android.synthetic.main.fragment_class.*
import kotlinx.android.synthetic.main.fragment_college.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClassFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClassFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recyclerViewAdapter: ClassRecyclerViewAdapter
    lateinit var viewModel: ClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_class, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerViewClass.apply {
            layoutManager = LinearLayoutManager(this@ClassFragment.context)
            val decoration =
                DividerItemDecoration(this@ClassFragment.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = ClassRecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ClassViewModel::class.java)
        viewModel.getClassListObservable().observe(viewLifecycleOwner, Observer<ClassList> {
            if (it == null) {
                Toast.makeText(activity, "no class data found", Toast.LENGTH_LONG).show()
            } else {
                recyclerViewAdapter.classList = it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getClassesList()
    }
}