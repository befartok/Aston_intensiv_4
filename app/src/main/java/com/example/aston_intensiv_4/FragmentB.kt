package com.example.aston_intensiv_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.databinding.FragmentABinding
import com.example.aston_intensiv_4.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater,container, false)

        binding.buttonToGoFragmentC.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachB")
                .replace(R.id.fragment_container, FragmentC.newInstance("Hello Fragment C")).commit()
        }

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =  FragmentB()
    }
}