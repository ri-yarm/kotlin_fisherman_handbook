package com.example.fishermanhandbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fishermanhandbook.databinding.ContentLayoutBinding

class ContentActivity: AppCompatActivity() {
    private lateinit var binding: ContentLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvTitle = binding.tvTitle
        val tvDesc = binding.tvDesc
        val tvImage= binding.tvImage

        tvTitle.text = intent.getStringExtra("title")
        tvDesc.text = intent.getStringExtra("content")
        tvImage.setImageResource(intent.getIntExtra("image", R.drawable.ic_fish))
    }
}