package com.example.roteiroandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            if(binding.editEmail.text.toString() == "" || binding.editNome.text.toString() == "" || binding.editNomeUSER.text.toString() == "" || binding.editPassword.text.toString() == "" || binding.confirmPass.text.toString() == ""){

                Toast.makeText(this, "Os campos não podem estar vazios", Toast.LENGTH_SHORT).show()

            }else{

                if(binding.editPassword.text.toString() == binding.confirmPass.text.toString()){
                    Toast.makeText(this, "Conta Criado com Sucesso", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "As palavras-passes são diferentes", Toast.LENGTH_SHORT).show()
                    binding.editPassword.text.clear()
                    binding.confirmPass.text.clear()
                }
            }
        })

        binding.backbutton.setOnClickListener({
            val intent = Intent(this, IndexLogin::class.java)
            startActivity(intent)
        })
    }
}