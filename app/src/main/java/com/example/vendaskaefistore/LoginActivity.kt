package com.example.vendaskaefistore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vendaskaefistore.databinding.ActivityLoginBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore
    }
}