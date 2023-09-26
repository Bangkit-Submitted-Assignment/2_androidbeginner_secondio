package com.dicoding.mysubmission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

//    companion object{
//        const val EXTRA_CHARACTER = "extra_character"
//    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var mShare : Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mShare = findViewById(R.id.action_share)
        mShare.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "type/palin"
            val shareBody = "You are body"
            val shareSub = "You subject here"
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
            myIntent.putExtra(Intent.EXTRA_TEXT, shareSub)
            startActivity(Intent.createChooser(myIntent, "Share your app"))
        }

        val dataCharacter = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Character>(ListCharAdapter.EXTRA_APALA, Character::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Character>(ListCharAdapter.EXTRA_APALA)
        }

        val actionbar = supportActionBar
        actionbar?.title = dataCharacter?.name
        actionbar?.setDefaultDisplayHomeAsUpEnabled(true)

        val tvDetailName:TextView = findViewById(R.id.name_char_detail)
        val tvDetailDescription:TextView = findViewById(R.id.deskripsi_detail)
        val ivDetailPhoto:ImageView = findViewById(R.id.image_detail_activity)

        tvDetailName.text = dataCharacter?.name
        tvDetailDescription.text = dataCharacter?.description
        dataCharacter?.photo?.let { ivDetailPhoto.setImageResource(it) }
        }

    }