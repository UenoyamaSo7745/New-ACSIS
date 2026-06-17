package com.acsis.medicamentos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.acsis.medicamentos.databinding.FragmentHistoryBinding
import com.acsis.medicamentos.data.database.ACBDDatabase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var database: ACBDDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        database = ACBDDatabase.getInstance(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadTodayHistory()
    }

    private fun loadTodayHistory() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(Date())

        lifecycleScope.launch {
            val takenCount = database.medicationHistoryDao().getTakenCountByDate(today)
            val missedCount = database.medicationHistoryDao().getMissedCountByDate(today)

            takenCount.collect { taken ->
                binding.tvDosesTaken.text = taken.toString()
            }

            missedCount.collect { missed ->
                binding.tvDosesMissed.text = missed.toString()
            }
        }
    }
}
