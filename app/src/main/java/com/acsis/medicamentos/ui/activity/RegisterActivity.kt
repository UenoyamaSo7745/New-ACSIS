package com.acsis.medicamentos.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.acsis.medicamentos.databinding.ActivityRegisterBinding
import com.acsis.medicamentos.data.database.ACBDDatabase
import com.acsis.medicamentos.data.entity.User
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var database: ACBDDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = ACBDDatabase.getInstance(this)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registerUser(fullName, email, password)
        }

        binding.tvLogin.setOnClickListener {
            finish()
        }
    }

    private fun registerUser(fullName: String, email: String, password: String) {
        lifecycleScope.launch {
            try {
                val existingUser = database.userDao().getUserByEmail(email)
                if (existingUser != null) {
                    Toast.makeText(this@RegisterActivity, "El email ya está registrado", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                val newUser = User(
                    email = email,
                    password = password,
                    fullName = fullName
                )

                val userId = database.userDao().insertUser(newUser)

                if (userId > 0) {
                    Toast.makeText(this@RegisterActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    val prefs = getSharedPreferences("acsis_prefs", MODE_PRIVATE)
                    prefs.edit().putInt("user_id", userId.toInt()).apply()
                    prefs.edit().putString("user_email", email).apply()

                    startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                    finish()
                }
            } catch (e: Exception) {
                Toast.makeText(this@RegisterActivity, "Error en el registro", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
