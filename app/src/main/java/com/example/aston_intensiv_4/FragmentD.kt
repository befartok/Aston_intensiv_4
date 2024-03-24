package com.example.aston_intensiv_4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.databinding.FragmentDBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: FragmentDBinding

class FragmentD : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater, container, false)


        binding.buttonGoBackToB.setOnClickListener {
            parentFragmentManager.popBackStack("attachB", 1)
        }
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentD()
    }

}