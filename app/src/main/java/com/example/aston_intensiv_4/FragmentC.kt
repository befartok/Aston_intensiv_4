package com.example.aston_intensiv_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_4.databinding.FragmentCBinding

private const val MESSAGE_KEY_EXTRA = "MESSAGE_KEY_EXTRA"

class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater, container, false)

        val msg = requireArguments().getString(MESSAGE_KEY_EXTRA)

        binding.textViewFragmentsC.text = msg


        binding.buttonToGoFragmentD.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.fragment_container, FragmentD.newInstance()).commit()
        }

        binding.buttonGoBackToA.setOnClickListener {
            parentFragmentManager.popBackStack("attachA", 1)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(msg: String): FragmentC {
            return FragmentC().apply {
                arguments = Bundle().also { it.putString(MESSAGE_KEY_EXTRA, msg) }
            }
        }
    }
}