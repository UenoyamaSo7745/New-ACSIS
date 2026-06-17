package com.acsis.medicamentos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.acsis.medicamentos.databinding.FragmentDashboardBinding
import com.acsis.medicamentos.data.database.ACBDDatabase
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var database: ACBDDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        database = ACBDDatabase.getInstance(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadMedications()
    }

    private fun setupUI() {
        binding.btnAddMedication.setOnClickListener {
            // Navigate to add medication
        }
    }

    private fun loadMedications() {
        val prefs = requireContext().getSharedPreferences("acsis_prefs", android.content.Context.MODE_PRIVATE)
        val userId = prefs.getInt("user_id", -1)

        if (userId != -1) {
            lifecycleScope.launch {
                database.medicationDao().getMedicationsByUser(userId).collect { medications ->
                    // Update UI with medications
                    binding.tvNextDoseTime.text = "EN ${medications.size} MEDICAMENTOS"
                }
            }
        }
    }
}
