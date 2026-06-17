package com.acsis.medicamentos.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "medications",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Medication(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val name: String,
    val description: String,
    val dosage: String,
    val stock: Int,
    val expirationDate: String,
    val imageUrl: String? = null,
    val createdAt: Long = System.currentTimeMillis()
)
