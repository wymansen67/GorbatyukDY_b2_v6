package com.bignerdranch.android.gorbatyukdy_b2_v6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.bignerdranch.android.gorbatyukdy_b2_v6.databinding.ActivityDataViewBinding

class DataViewActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityDataViewBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataViewBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_data_view)

        var spinnerData = resources.getStringArray(R.array.spinnerData)
        var item = intent.getStringExtra("id").toString()
        if (item.isNotEmpty()){
            var id = item.toInt()
            binding.tvName.setText(spinnerData[id])
        }

        binding.fab.setOnClickListener{
            startActivity(Intent(this@DataViewActivity, LoginActivity::class.java))
            finish()
        }
    }
}