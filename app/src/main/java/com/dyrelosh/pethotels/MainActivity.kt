package com.dyrelosh.pethotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dyrelosh.pethotels.databinding.ActivityMainBinding
import com.dyrelosh.pethotels.manager.BottomNavManager
import com.yandex.mapkit.MapKitFactory


class MainActivity : AppCompatActivity(), BottomNavManager {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MapKitFactory.setApiKey("ce5fb59c-f7df-43b9-8a53-a89e7b46c168")
        MapKitFactory.initialize(this)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        binding.bottomNavigationUser.setupWithNavController(navController)

    }


    override fun setBottomNavVisibility(isVisible: Boolean) {
        binding.bottomNavigationUser.isVisible = isVisible
    }
}