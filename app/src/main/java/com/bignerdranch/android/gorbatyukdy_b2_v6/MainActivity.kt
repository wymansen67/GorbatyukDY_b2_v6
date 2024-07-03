package com.bignerdranch.android.gorbatyukdy_b2_v6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.bignerdranch.android.gorbatyukdy_b2_v6.databinding.ActivityLoginBinding
import com.bignerdranch.android.gorbatyukdy_b2_v6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var spinner = binding.spinner
        var spinnerData = resources.getStringArray(R.array.spinnerData)
        var adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, spinnerData)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)
        spinner.onItemSelectedListener = this


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var id = parent?.selectedItemId
        intent = Intent(this@MainActivity, DataViewActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}