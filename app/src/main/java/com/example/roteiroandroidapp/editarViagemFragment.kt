package com.example.roteiroandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roteiroandroidapp.databinding.FragmentEditarViagemBinding
import com.example.roteiroandroidapp.databinding.FragmentIndexViagemBinding

class editarViagemFragment : Fragment() {

    private var _binding: FragmentEditarViagemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarViagemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editarlocal?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, editarLocalFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.save.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, IndexViagemFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.backbutton.setOnClickListener({
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, IndexViagemFragment())
                .addToBackStack(null)
                .commit()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
