package com.example.aston_intensiv_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.databinding.FragmentABinding

// TODO: убрать текст вью с буквами фрагментов

class FragmentA : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater,container, false)

        binding.buttonToGoFragmentB.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachA")
                .replace(R.id.fragment_container, FragmentB.newInstance()).commit()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =  FragmentA()
    }

}