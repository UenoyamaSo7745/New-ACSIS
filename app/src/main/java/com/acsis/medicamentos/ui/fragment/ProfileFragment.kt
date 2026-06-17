package com.acsis.medicamentos.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.acsis.medicamentos.databinding.FragmentProfileBinding
import com.acsis.medicamentos.data.database.ACBDDatabase
import com.acsis.medicamentos.ui.activity.LoginActivity
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var database: ACBDDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        database = ACBDDatabase.getInstance(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadUserProfile()
    }

    private fun setupUI() {
        binding.btnLogout.setOnClickListener {
            logout()
        }

        binding.btnEmergency.setOnClickListener {
            // Call emergency number
        }

        binding.btnSettings.setOnClickListener {
            // Navigate to settings
        }
    }

    private fun loadUserProfile() {
        val prefs = requireContext().getSharedPreferences("acsis_prefs", android.content.Context.MODE_PRIVATE)
        val userId = prefs.getInt("user_id", -1)
        val userEmail = prefs.getString("user_email", "")

        lifecycleScope.launch {
            database.userDao().getUserById(userId).collect { user ->
                if (user != null) {
                    binding.tvUserEmail.text = user.email
                    binding.tvUserName.text = user.fullName
                }
            }
        }
    }

    private fun logout() {
        val prefs = requireContext().getSharedPreferences("acsis_prefs", android.content.Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
        startActivity(Intent(requireContext(), LoginActivity::class.java))
        requireActivity().finish()
    }
}
