package com.example.aston_intensiv_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_4.databinding.ActivityUsersListBinding

class UsersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.usersFragmentContainerView, ListUsersFragment.newInstance()).commit()

    }

}