package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.myapplication1.adapter.RecyclerViewAdapter
import com.example.myapplication1.fragment.*
import com.example.myapplication1.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggleDrawer: ActionBarDrawerToggle

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  initRecyclerView()
        // initViewModel()

        drawerToggle()
    }

    private fun drawerToggle() {
        toggleDrawer = ActionBarDrawerToggle(this, drawerMain, R.string.open, R.string.close)
        drawerMain.addDrawerListener(toggleDrawer)
        toggleDrawer.syncState()

        switchFragments()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun changeFragment(frag: Fragment, title: String): Boolean {
        supportActionBar?.title = title
        val fragment = supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutMain, frag)
            .commit()
        drawerMain.closeDrawer(GravityCompat.START)
        return true
    }

    private fun switchFragments() {
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.collegesMenuItem ->
                    changeFragment(CollegeFragment(), "Colleges")
                R.id.majorsMenuItem ->
                    changeFragment(MajorFragment(), "Majors")
                R.id.classesMenuItem ->
                    changeFragment(ClassFragment(), "Classes")
                R.id.teachersMenuItem ->
                    changeFragment(TeacherFragment(), "Teachers")
                R.id.studentsMenuItem ->
                    changeFragment(StudentFragment(), "Students")
                R.id.reportsMenuItem ->
                    changeFragment(ReportFragment(), "Reports")
                else ->
                    changeFragment(ReportFragment(), "Reports")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggleDrawer.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
/*
    private fun initRecyclerView() {
        recyclerViewTeacher.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration =
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getTeacherListObservable().observe(this, Observer<TeacherList> {
            if (it == null) {
                Toast.makeText(this@MainActivity, "nothing found", Toast.LENGTH_LONG).show()
            } else {
                recyclerViewAdapter.teacherList = it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getTeachersList()
    }*/

}