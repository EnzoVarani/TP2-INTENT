package com.varani.cadastrolivros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.varani.cadastrolivros.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(MainActivity.EXTRA_TITLE).orEmpty()
        val author = intent.getStringExtra(MainActivity.EXTRA_AUTHOR).orEmpty()

        binding.tvBookTitle.text = "Título: $title"
        binding.tvBookAuthor.text = "Autor: $author"

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
