package com.madhusudan.livedatademo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.madhusudan.livedatademo.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.madhusudan.livedatademo.network.data.Example as Example1

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    var mProgressBar: ProgressBar? = null
    lateinit var txtActiveName: TextView
    lateinit var totalConfirmed: TextView
    lateinit var totalRecovered: TextView
    lateinit var totalDeaths: TextView
    lateinit var details_layout: RelativeLayout
    lateinit var failure_layout: RelativeLayout
    lateinit var country_spinner: Spinner
     var selectedState: String?=null



    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtActiveName   = findViewById(R.id.txtActiveName)
        totalConfirmed   = findViewById(R.id.txtConfirmCases)
         totalRecovered = findViewById(R.id.txtRecovered)
         totalDeaths = findViewById(R.id.txtTotalDeaths)
        details_layout = findViewById(R.id.details_layout)
        failure_layout = findViewById(R.id.failure_layout)
        country_spinner = findViewById(R.id.country_spinner)
        spinnerData()
        // Spinner click listener
        country_spinner.onItemSelectedListener = this

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        mProgressBar = progressBar
        progressBar.visibility = View.VISIBLE

       val data = Observer<Example1> {
            progressBar.visibility = View.GONE
           if(it.statewise!!.isEmpty()){
               progressBar.visibility = View.GONE
               details_layout.visibility==View.GONE
               failure_layout.visibility==View.VISIBLE

           }else{
               progressBar.visibility = View.GONE
               details_layout.visibility==View.VISIBLE
               failure_layout.visibility==View.GONE
               totalConfirmed.text = it.statewise!!.get(0).confirmed
               totalRecovered.text = it.statewise!!.get(0).recovered
               totalDeaths.text = it.statewise!!.get(0).deaths
               txtActiveName.text = it.statewise!!.get(0).active
               Log.e("tetsing",it.statewise!!.get(0).statecode)
           }





       }
        failure_layout.setOnClickListener {
            viewModel.callAPI().observe(this,data)

        }
        viewModel.callAPI().observe(this,data)


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
         selectedState = parent!!.getItemAtPosition(position).toString()
      //  viewModel.callAPI(selectedState).observe(this,data)

    }

    private fun spinnerData() { // Spinner Drop down elements
        val categories: MutableList<String> =
            ArrayList()
        categories.add("Karnataka")
        categories.add("Tamilnadu")
        categories.add("Andhra Pradesh")
        categories.add("Assam")
        categories.add("Puducherry")
        // Creating adapter for spinner
        val dataAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // co data adapter to spinner
        country_spinner.adapter = dataAdapter
    }
}
