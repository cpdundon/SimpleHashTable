package com.example.simplehashtable.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.simplehashtable.databinding.ActivityMainBinding
import com.example.simplehashtable.utils.HashTableExperiment
import com.example.simplehashtable.utils.HashTableGeneric

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val hte = HashTableGeneric<String, String>(1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hte.insertValue("CPD", "Christopher Patrick Dundon")
        hte.insertValue("LDF", "Lorraine Dorothy Fenenbock")
        hte.insertValue("BJD", "Brett Jerome Davis")
    }

    override fun onResume() {
        super.onResume()

        setListeners()
    }

    private fun setListeners() {
        binding.btnFetchValue.setOnClickListener(View.OnClickListener {
            onFetch()
        })
    }

    private fun onFetch() {
        val value = hte.getValue(binding.etKey.text.toString())
        binding.tvValue.text = value
    }
}