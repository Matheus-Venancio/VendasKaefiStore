package com.example.vendaskaefistore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.vendaskaefistore.databinding.ActivityLoginBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore
        var edtUser = binding.edtUser
        var edtPassword = binding.edtPassword
        var btnEnter = binding.btnEnter

        btnEnter.setOnClickListener(View.OnClickListener {
            if (edtUser.text.isEmpty()||edtPassword.text.isEmpty()){
                Toast.makeText(this,"Preencha os campos", Toast.LENGTH_SHORT).show()
            }else{
                val userRef = db.collection("bank").document(edtUser.text.toString())
                userRef.get().addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        val document = task.result
                        if (document!=null){
                            var userId = document.id
                            if (userId.equals(edtUser.text.toString())){
                                var passwordId = document.getString("password")
                                if (passwordId.equals(edtPassword.text.toString())){
                                    Toast.makeText(this,"Entrando", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                }else{
                                    Toast.makeText(this,"Senha incorreta", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }else{
                            Toast.makeText(this, "Usuario não encontrado (primeiro else)",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this,"Usuario não encontrado (Segundo else)", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }
}