package com.example.aston_intensiv_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.databinding.FragmentCBinding
import com.example.aston_intensiv_4.databinding.FragmentDBinding

private lateinit var binding: FragmentDBinding

class FragmentD : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDBinding.inflate(inflater, container, false)


        binding.buttonGoBackToB.setOnClickListener {
            parentFragmentManager.popBackStack("attachB", 1)
        }
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance() =  FragmentD()
    }

/*    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentD().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}