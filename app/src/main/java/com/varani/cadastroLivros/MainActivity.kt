package com.varani.cadastrolivros

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.varani.cadastrolivros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val title = binding.etBookTitle.text.toString().trim()
            val author = binding.etBookAuthor.text.toString().trim()

            if (title.isBlank() || author.isBlank()) {
                Snackbar.make(binding.root, "Preencha título e autor.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_AUTHOR, author)
            }
            startActivity(intent)
        }
    }
}
