package com.bignerdranch.android.gorbatyukdy_b2_v6

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bignerdranch.android.gorbatyukdy_b2_v6.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp: SharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        binding.buttonLogin.setOnClickListener{

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            var a = AlertDialog.Builder(this@LoginActivity)
            a.setTitle("Error")
                .setMessage("Почта и пароль не могут быть пустыми")
                .setCancelable(false)
                .setPositiveButton("Ok"){dialog, _ -> dialog.dismiss()}
                .create()

            if (sp.all.isNullOrEmpty()){
                if (email.isNotEmpty() && password.isNotEmpty()){
                    sp.edit().putString("email", email).putString("psswd", password).apply()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
                a.show()
            }
            else{
                if (email.isNotEmpty() && password.isNotEmpty()){

                    val savedEmail = sp.getString("email", "")
                    val savedPassword = sp.getString("password", "")
                    var pass = true

                    if (email != savedEmail){
                        Snackbar.make(it, "Неверный логин", Snackbar.LENGTH_SHORT).show()
                        pass = false
                    }
                    if (password != savedPassword){
                        Snackbar.make(it, "Неверный пароль", Snackbar.LENGTH_SHORT).show()
                        pass = false
                    }
                    if (pass){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                }
                a.show()
            }
        }
    }
}