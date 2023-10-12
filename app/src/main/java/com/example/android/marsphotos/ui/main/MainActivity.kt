package com.example.android.marsphotos.ui.main

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.ActivityMainBinding
import com.example.android.marsphotos.ui.film.FilmFragment
import com.example.android.marsphotos.ui.hbo.HBOFragment
import com.example.android.marsphotos.ui.home.HomeFragment
import com.example.android.marsphotos.ui.orther.OrtherFragment
import com.example.android.marsphotos.ui.television.TelevisionFragment

class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {

                R.id.home -> replaceFragment(HomeFragment())
                R.id.truyenhinh -> replaceFragment(TelevisionFragment())
                R.id.film -> replaceFragment(FilmFragment())
                R.id.hbo -> replaceFragment(HBOFragment())
                R.id.orther -> replaceFragment(OrtherFragment())
                else -> {

                }
            }

                true
            }
        }


    fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_main, fragment)
        fragmentTransaction.commit()

    }
}