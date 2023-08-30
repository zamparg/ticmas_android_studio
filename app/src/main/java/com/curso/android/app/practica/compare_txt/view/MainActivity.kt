package com.curso.android.app.practica.compare_txt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.android.app.practica.compare_txt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compareData.observe(this){
            binding.LOresult.text = "${it.result}"
        }

        binding.CompareButton.setOnClickListener{
            mainViewModel.compareTxt(
                binding.editText1.text.toString(),
                binding.editText2.text.toString())
        }
    }
}