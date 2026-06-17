package com.acsis.medicamentos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.acsis.medicamentos.databinding.FragmentMedicationsBinding
import com.acsis.medicamentos.data.database.ACBDDatabase
import kotlinx.coroutines.launch

class MedicationsFragment : Fragment() {
    private lateinit var binding: FragmentMedicationsBinding
    private lateinit var database: ACBDDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMedicationsBinding.inflate(inflater, container, false)
        database = ACBDDatabase.getInstance(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadMedications()
    }

    private fun setupRecyclerView() {
        binding.rvMedications.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadMedications() {
        val prefs = requireContext().getSharedPreferences("acsis_prefs", android.content.Context.MODE_PRIVATE)
        val userId = prefs.getInt("user_id", -1)

        if (userId != -1) {
            lifecycleScope.launch {
                database.medicationDao().getMedicationsByUser(userId).collect { medications ->
                    // Update RecyclerView with medications
                }
            }
        }
    }
}
