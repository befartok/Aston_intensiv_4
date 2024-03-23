package com.example.aston_intensiv_4

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import coil.load
import com.example.aston_intensiv_4.databinding.FragmentEditUsersBinding
import com.example.aston_intensiv_4.databinding.FragmentListUsersBinding

private const val MESSAGE_KEY_EXTRA = "MESSAGE_KEY_EXTRA"


class EditUsersFragment : Fragment() {
    private lateinit var binding: FragmentEditUsersBinding
    var idUser:Int =-1
    var imgLink =""
    fun setBinding(id: Int) {
        binding.etFirstName.setText(ListUsersFragment.getUsers()[id].firstName)
        binding.etLastName.setText(ListUsersFragment.getUsers()[id].lastName)
        binding.etPhoneNumber.setText(ListUsersFragment.getUsers()[id].phoneNumber)
        binding.imageView.load(ListUsersFragment.getUsers()[id].imgLink)
        imgLink=ListUsersFragment.getUsers()[id].imgLink
        idUser = ListUsersFragment.getUsers()[id].id
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditUsersBinding.inflate(inflater, container, false)
        val idUsers = requireArguments().getString(MESSAGE_KEY_EXTRA)

        when (idUsers) {
            "id1" -> setBinding(0)
            "id2" -> setBinding(1)
            "id3" -> setBinding(2)
            "id4" -> setBinding(3)
        }



/*        val activity: Activity? = activity
        Toast.makeText(activity, "result3= $result3", Toast.LENGTH_SHORT).show()*/


        binding.buttonCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.buttonOk.setOnClickListener {

            parentFragmentManager.setFragmentResult("requestKey", bundleOf(
                "bundleKeyFirstName" to binding.etFirstName.text.toString(),
                "bundleKeyLastName" to binding.etLastName.text.toString(),
                "bundleKeyPhoneNumber" to binding.etPhoneNumber.text.toString(),
                "bundleKeyImgLink" to imgLink,
                "bundleKeyId" to idUsers.toString()
                ))
   //         parentFragmentManager.setFragmentResult("requestKey2", bundleOf("bundleKey2" to lastName))
            /*            val activity: Activity? = activity
                        Toast.makeText(activity, "result3= $result", Toast.LENGTH_SHORT).show()*/
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