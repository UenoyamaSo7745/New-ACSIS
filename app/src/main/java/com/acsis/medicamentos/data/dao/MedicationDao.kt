package com.acsis.medicamentos.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.acsis.medicamentos.data.entity.Medication
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationDao {
    @Insert
    suspend fun insertMedication(medication: Medication): Long

    @Update
    suspend fun updateMedication(medication: Medication)

    @Delete
    suspend fun deleteMedication(medication: Medication)

    @Query("SELECT * FROM medications WHERE userId = :userId")
    fun getMedicationsByUser(userId: Int): Flow<List<Medication>>

    @Query("SELECT * FROM medications WHERE id = :medicationId LIMIT 1")
    fun getMedicationById(medicationId: Int): Flow<Medication?>

    @Query("UPDATE medications SET stock = stock - 1 WHERE id = :medicationId")
    suspend fun decreaseStock(medicationId: Int)
}
