package com.dicoding.mysubmission

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfilePage : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)
        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDefaultDisplayHomeAsUpEnabled(true)
    }
}