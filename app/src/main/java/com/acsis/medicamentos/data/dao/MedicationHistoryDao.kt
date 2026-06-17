package com.acsis.medicamentos.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.acsis.medicamentos.data.entity.MedicationHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationHistoryDao {
    @Insert
    suspend fun insertHistory(history: MedicationHistory): Long

    @Update
    suspend fun updateHistory(history: MedicationHistory)

    @Delete
    suspend fun deleteHistory(history: MedicationHistory)

    @Query("SELECT * FROM medication_history WHERE medicationId = :medicationId ORDER BY date DESC")
    fun getHistoryByMedication(medicationId: Int): Flow<List<MedicationHistory>>

    @Query("SELECT * FROM medication_history WHERE date = :date ORDER BY scheduledTime ASC")
    fun getHistoryByDate(date: String): Flow<List<MedicationHistory>>

    @Query("SELECT COUNT(*) FROM medication_history WHERE isTaken = 1 AND date = :date")
    fun getTakenCountByDate(date: String): Flow<Int>

    @Query("SELECT COUNT(*) FROM medication_history WHERE isTaken = 0 AND date = :date")
    fun getMissedCountByDate(date: String): Flow<Int>
}
