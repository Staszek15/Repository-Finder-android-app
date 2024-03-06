package com.staszek15.repositoryfinder.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.staszek15.repositoryfinder.databinding.ActivityMainBinding import getBranches
import main

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide()

        setupClickListeners()

    }



    private fun setupClickListeners() {
        binding.buttonSearch.setOnClickListener {
            val intent = Intent(this, RepositoryListActivity::class.java)
            startActivity(intent)
        }
    }
}