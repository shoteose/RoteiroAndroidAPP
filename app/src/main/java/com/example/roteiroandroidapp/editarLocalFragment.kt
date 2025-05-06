package com.example.roteiroandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roteiroandroidapp.databinding.FragmentEditarLocalBinding
import com.example.roteiroandroidapp.databinding.FragmentVerLocalBinding

class editarLocalFragment : Fragment() {

    private var _binding: FragmentEditarLocalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditarLocalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editarRESTAURANTE?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, editarLocationFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.addLocal?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddLocalFragment())
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
