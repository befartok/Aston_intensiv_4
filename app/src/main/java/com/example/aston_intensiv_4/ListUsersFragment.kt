package com.example.aston_intensiv_4

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import coil.load
import com.example.aston_intensiv_4.databinding.FragmentListUsersBinding
import com.github.javafaker.Faker
import java.util.Locale


class ListUsersFragment : Fragment() {


    private lateinit var binding: FragmentListUsersBinding
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUsers()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setFragmentResultListener("requestKey") { key, bundle ->
            binding.textViewFirstName1.text = bundle.getString("bundleKeyFirstName")
            binding.textViewLastName1.text = bundle.getString("bundleKeyLastName")
            binding.phoneNumber1.text = bundle.getString("bundleKeyPhoneNumber")
            binding.imageView1.load(bundle.getString("bundleKeyImgLink"))
            var idUser = bundle.getString("bundleKeyId")
           /* val activity: Activity? = activity
            Toast.makeText(activity, "result1= $test", Toast.LENGTH_SHORT).show()*/
        }


        binding = FragmentListUsersBinding.inflate(inflater, container, false)

        binding.textViewFirstName1.text = getUsers()[0].firstName
        binding.textViewFirstName2.text = getUsers()[1].firstName
        binding.textViewFirstName3.text = getUsers()[2].firstName
        binding.textViewFirstName4.text = getUsers()[3].firstName

        binding.textViewLastName1.text = getUsers()[0].lastName
        binding.textViewLastName2.text = getUsers()[1].lastName
        binding.textViewLastName3.text = getUsers()[2].lastName
        binding.textViewLastName4.text = getUsers()[3].lastName

        binding.phoneNumber1.text = getUsers()[0].phoneNumber
        binding.phoneNumber2.text = getUsers()[1].phoneNumber
        binding.phoneNumber3.text = getUsers()[2].phoneNumber
        binding.phoneNumber4.text = getUsers()[3].phoneNumber

        binding.imageView1.load("https://placebeard.it/200")
        binding.imageView2.load("https://placebeard.it/199")
        binding.imageView3.load("https://placebeard.it/198")
        binding.imageView4.load("https://placebeard.it/197")



        binding.user1.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachList")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("id1"))
                .commit()
        }

        binding.user2.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachList")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("id2"))
                .commit()
        }

        binding.user3.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachList")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("id3"))
                .commit()
        }

        binding.user4.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("attachList")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("id4"))
                .commit()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListUsersFragment()

        //val faker = Faker(Locale("RU"))

        private var users = emptyList<ContactModel>().toMutableList()

        fun initUsers(): MutableList<ContactModel> {
            val faker = Faker(Locale("RU"))
            users = (1..4).map {
                ContactModel(
                    id = it,
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    phoneNumber = faker.phoneNumber().phoneNumber(),
                    imgLink = "https://placebeard.it/${201 - it}"
                )
            }.toMutableList()

            return users
        }

        fun getUsers(): MutableList<ContactModel> {

            return users
        }

        fun setUsers(result: String): String {

            return result + "12345"

        }
    }

}