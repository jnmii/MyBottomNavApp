package com.example.mybottomnavapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mybottomnavapp.R
import com.example.mybottomnavapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        // tab -> also import the library required -> removes anything after it
        // enter -> only autofils and you need to import

        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        val appConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_rick,
                R.id.navigation_list,
                R.id.navigation_detail
            )
        )

        setupActionBarWithNavController(navController, appConfiguration)
        navView.setupWithNavController(navController)




    }

}