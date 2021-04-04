package com.example.simplehashtable.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplehashtable.R
import com.example.simplehashtable.databinding.ActivityMainBinding
import com.example.simplehashtable.utils.HashTableExperiment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val hte = HashTableExperiment(100)

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

        hte.getValue("CPD")?.let{
            binding.tvValue.text = it
        }
    }
}