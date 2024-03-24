package com.example.aston_intensiv_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import coil.load
import com.example.aston_intensiv_4.databinding.FragmentListUsersBinding
import com.github.javafaker.Faker
import java.util.Locale


class ListUsersFragment : Fragment() {
// TODO: заменить список на RecyclerView
// TODO: повороты исправить

    private lateinit var binding: FragmentListUsersBinding

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putParcelableArrayList("usersKey", users as ArrayList<ContactModel>)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if (savedInstanceState == null) {
            initUsers()
        }

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList("usersKey")!!
        }

        setFragmentResultListener("requestKey") { key, bundle ->

            val keyFirstName = bundle.getString("bundleKeyFirstName")
            val keyLastName = bundle.getString("bundleKeyLastName")
            val keyPhoneNumber = bundle.getString("bundleKeyPhoneNumber")
            val keyImgLink = bundle.getString("bundleKeyImgLink")
            val idUser = bundle.getString("bundleKeyId")

            setBinding(idUser?.toInt(), keyFirstName, keyLastName, keyPhoneNumber, keyImgLink)
            setUsers(idUser?.toInt(), keyFirstName, keyLastName, keyPhoneNumber, keyImgLink)

        }

        binding = FragmentListUsersBinding.inflate(inflater, container, false)
        initBinding()

        return binding.root
    }

    private fun setBinding(
        id: Int?,
        keyFirstName: String?,
        keyLastName: String?,
        keyPhoneNumber: String?,
        keyImgLink: String?,
    ) {

        when (id) {
            0 -> {
                binding.textViewFirstName1.text = keyFirstName
                binding.textViewLastName1.text = keyLastName
                binding.phoneNumber1.text = keyPhoneNumber
                binding.imageView1.load(keyImgLink)
            }

            1 -> {
                binding.textViewFirstName2.text = keyFirstName
                binding.textViewLastName2.text = keyLastName
                binding.phoneNumber2.text = keyPhoneNumber
                binding.imageView2.load(keyImgLink)
            }

            2 -> {
                binding.textViewFirstName3.text = keyFirstName
                binding.textViewLastName3.text = keyLastName
                binding.phoneNumber3.text = keyPhoneNumber
                binding.imageView3.load(keyImgLink)
            }

            3 -> {
                binding.textViewFirstName4.text = keyFirstName
                binding.textViewLastName4.text = keyLastName
                binding.phoneNumber4.text = keyPhoneNumber
                binding.imageView4.load(keyImgLink)
            }
        }
    }

    private fun initBinding() {
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

        binding.imageView1.load(getUsers()[0].imgLink)
        binding.imageView2.load(getUsers()[1].imgLink)
        binding.imageView3.load(getUsers()[2].imgLink)
        binding.imageView4.load(getUsers()[3].imgLink)

        initCliks()

    }

    fun initCliks() {
        binding.user1.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("0"))
                .commit()
        }
        binding.user2.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("1"))
                .commit()
        }
        binding.user3.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("null")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("2"))
                .commit()
        }
        binding.user4.setOnClickListener {
            parentFragmentManager.beginTransaction().addToBackStack("null")
                .replace(R.id.usersFragmentContainerView, EditUsersFragment.newInstance("3"))
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListUsersFragment()

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

        fun setUsers(
            idUser: Int?,
            keyFirstName: String?,
            keyLastName: String?,
            keyPhoneNumber: String?,
            keyImgLink: String?
        ): MutableList<ContactModel> {

            if (keyFirstName != null) {
                users[idUser!!].firstName = keyFirstName
            }
            if (keyLastName != null) {
                users[idUser!!].lastName = keyLastName
            }
            if (keyPhoneNumber != null) {
                users[idUser!!].phoneNumber = keyPhoneNumber
            }
            if (keyImgLink != null) {
                users[idUser!!].imgLink = keyImgLink
            }

            return users
        }
    }

}