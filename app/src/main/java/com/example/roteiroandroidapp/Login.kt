package com.example.roteiroandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roteiroandroidapp.databinding.ActivityLogin2Binding

class Login : AppCompatActivity() {

    private val binding by lazy { ActivityLogin2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener({

            var email = binding.editEmail.text.toString()
            var pass = binding.editPassword.text.toString()

            if(email == "paulo@hugo.eduardo"){

                if(pass == "computacaomovel"){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    binding.editPassword.text.clear()
                    Toast.makeText(this, "Palavra-passe Incorreta", Toast.LENGTH_SHORT).show()
                }
            }else{

                Toast.makeText(this, "Não existe essa conta", Toast.LENGTH_SHORT).show()
                binding.editEmail.text.clear()
                binding.editPassword.text.clear()

            }

        })

        binding.backbutton.setOnClickListener({
            val intent = Intent(this, IndexLogin::class.java)
            startActivity(intent)
        })
    }
}