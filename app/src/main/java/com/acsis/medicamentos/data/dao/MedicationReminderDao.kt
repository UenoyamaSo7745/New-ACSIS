package com.acsis.medicamentos.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.acsis.medicamentos.data.entity.MedicationReminder
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationReminderDao {
    @Insert
    suspend fun insertReminder(reminder: MedicationReminder): Long

    @Update
    suspend fun updateReminder(reminder: MedicationReminder)

    @Delete
    suspend fun deleteReminder(reminder: MedicationReminder)

    @Query("SELECT * FROM reminders WHERE medicationId = :medicationId")
    fun getRemindersByMedication(medicationId: Int): Flow<List<MedicationReminder>>

    @Query("SELECT * FROM reminders WHERE isActive = 1")
    fun getActiveReminders(): Flow<List<MedicationReminder>>
}
