package com.example.roteiroandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roteiroandroidapp.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {

    private val binding by lazy{ ActivityRegistroBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCriarConta.setOnClickListener({

            val intent = Intent(this, Login::class.java)
            startActivity(intent)

        })

        binding.backbutton.setOnClickListener({

            val intent = Intent(this, IndexLogin::class.java)
            startActivity(intent)

        })


    }
}