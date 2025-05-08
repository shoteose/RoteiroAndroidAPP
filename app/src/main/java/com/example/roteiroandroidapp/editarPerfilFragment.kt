package com.example.roteiroandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.roteiroandroidapp.databinding.FragmentEditarPerfilBinding

class editarPerfilFragment : Fragment() {

    private var _binding: FragmentEditarPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.guardarPerfil.setOnClickListener {

            if(binding.editEmail?.text.toString().equals("") || binding.editNome?.text.toString().equals("") || binding.editNomeUSER?.text.toString().equals("") || binding.editPassword?.text.toString().equals("") || binding.confirmPass?.text.toString().equals("") ){

                Toast.makeText(context, "Os campos não podem estar vazios", Toast.LENGTH_SHORT).show()

            }else{

                if(binding.editPassword?.text.toString() == binding.confirmPass?.text.toString()){

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, IndexPerfilFragment())
                        .addToBackStack(null)
                        .commit()

                }else{

                    Toast.makeText(context, "As palavras-passes são diferentes", Toast.LENGTH_SHORT).show()

                    binding.editPassword?.text?.clear()
                    binding.confirmPass?.text?.clear()

                }

            }
        }

        binding.backbutton.setOnClickListener({
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, IndexPerfilFragment())
                .addToBackStack(null)
                .commit()
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
