package com.example.roteiroandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roteiroandroidapp.databinding.FragmentIndexViagemBinding

class IndexViagemFragment : Fragment() {

    private var _binding: FragmentIndexViagemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIndexViagemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imagekyoto.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, verViagemFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.editKyoto.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, editarLocalFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.fab.setOnClickListener({
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, CriarViagemFragment())
                .addToBackStack(null)
                .commit()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
