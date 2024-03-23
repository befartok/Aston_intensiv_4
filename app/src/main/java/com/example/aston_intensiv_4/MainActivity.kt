package com.example.aston_intensiv_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentA.newInstance()).commit()
        }

        binding.buttonOpenList.setOnClickListener {
            val randomIntent = Intent(this, UsersListActivity::class.java)
            startActivity(randomIntent)
        }

    }

    fun getScreensCount(): Int {
        return supportFragmentManager.backStackEntryCount + 1
    }


}