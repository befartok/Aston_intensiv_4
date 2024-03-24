package com.example.aston_intensiv_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import coil.load
import com.example.aston_intensiv_4.databinding.FragmentEditUsersBinding

private const val MESSAGE_KEY_EXTRA = "MESSAGE_KEY_EXTRA"

class EditUsersFragment : Fragment() {
    private lateinit var binding: FragmentEditUsersBinding
    private var idUser: Int = -1
    private fun setBinding(id: Int) {
        binding.etFirstName.setText(ListUsersFragment.getUsers()[id].firstName)
        binding.etLastName.setText(ListUsersFragment.getUsers()[id].lastName)
        binding.etPhoneNumber.setText(ListUsersFragment.getUsers()[id].phoneNumber)
        binding.imageView.load(ListUsersFragment.getUsers()[id].imgLink)
        binding.etLink.setText(ListUsersFragment.getUsers()[id].imgLink)
        idUser = ListUsersFragment.getUsers()[id].id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUsersBinding.inflate(inflater, container, false)
        val idUsers = requireArguments().getString(MESSAGE_KEY_EXTRA)

        when (idUsers) {
            "0" -> setBinding(0)
            "1" -> setBinding(1)
            "2" -> setBinding(2)
            "3" -> setBinding(3)
        }

        binding.buttonCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.buttonOk.setOnClickListener {

            parentFragmentManager.setFragmentResult(
                "requestKey", bundleOf(
                    "bundleKeyFirstName" to binding.etFirstName.text.toString(),
                    "bundleKeyLastName" to binding.etLastName.text.toString(),
                    "bundleKeyPhoneNumber" to binding.etPhoneNumber.text.toString(),
                    "bundleKeyImgLink" to binding.etLink.text.toString(),
                    "bundleKeyId" to idUsers.toString()

                )
            )
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(msg: String): EditUsersFragment {

            return EditUsersFragment().apply {
                arguments = Bundle().also { it.putString(MESSAGE_KEY_EXTRA, msg) }
            }
        }
    }
}