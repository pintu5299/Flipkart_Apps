package com.example.databindingmvvmdemo.views

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.databindingmvvmdemo.R

class Shopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val accountIcon: ImageView = findViewById(R.id.account_icon)
        accountIcon.setOnClickListener{
            val intent = Intent(this@Shopping,  ProfilePage::class.java)
            startActivity(intent)

        }
    }
}