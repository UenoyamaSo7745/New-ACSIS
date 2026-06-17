package com.acsis.medicamentos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acsis.medicamentos.databinding.ItemMedicationBinding
import com.acsis.medicamentos.data.entity.Medication

class MedicationAdapter(
    private val medications: List<Medication>,
    private val onItemClick: (Medication) -> Unit
) : RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    inner class MedicationViewHolder(private val binding: ItemMedicationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(medication: Medication) {
            binding.apply {
                tvMedicationName.text = medication.name
                tvMedicationDosage.text = medication.dosage
                tvMedicationStock.text = "Stock: ${medication.stock}"
                root.setOnClickListener { onItemClick(medication) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val binding = ItemMedicationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MedicationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        holder.bind(medications[position])
    }

    override fun getItemCount() = medications.size
}
