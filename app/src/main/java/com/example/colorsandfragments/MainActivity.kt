package com.example.colorsandfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment.newInstance()
        val secondFragment = SecondFragment.newInstance()

        supportFragmentManager.beginTransaction().replace(R.id.first_container,firstFragment).commit()

    }
}