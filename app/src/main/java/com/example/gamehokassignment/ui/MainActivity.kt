package com.example.gamehokassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gamehokassignment.R
import com.example.gamehokassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.main_fragment_container_view) as NavHostFragment
            val navController = navHostFragment.navController
            setUpBottomNav(navController)
        }




    }

    private fun setUpBottomNav(navController: NavController) {
        binding.bottomAppBar.setupWithNavController(navController)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}