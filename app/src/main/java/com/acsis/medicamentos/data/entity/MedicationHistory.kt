package com.acsis.medicamentos.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "medication_history",
    foreignKeys = [
        ForeignKey(
            entity = Medication::class,
            parentColumns = ["id"],
            childColumns = ["medicationId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MedicationHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val medicationId: Int,
    val scheduledTime: String,
    val takenTime: String? = null,
    val isTaken: Boolean = false,
    val notes: String? = null,
    val date: String, // Format: yyyy-MM-dd
    val createdAt: Long = System.currentTimeMillis()
)
