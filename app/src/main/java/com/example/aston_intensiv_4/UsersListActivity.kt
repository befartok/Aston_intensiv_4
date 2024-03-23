package com.example.aston_intensiv_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_4.databinding.ActivityUsersListBinding
import java.util.Locale
import com.github.javafaker.Faker


class UsersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)



/*        for (i in 0..3){
            Toast.makeText(this, "users[i]= ${users[i]}", Toast.LENGTH_SHORT).show()
        }*/
        supportFragmentManager.beginTransaction()
            .add(R.id.usersFragmentContainerView, ListUsersFragment.newInstance()).commit()

    }
}