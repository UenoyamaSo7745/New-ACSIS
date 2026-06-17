package com.acsis.medicamentos.repository

import com.acsis.medicamentos.data.dao.MedicationDao
import com.acsis.medicamentos.data.entity.Medication
import kotlinx.coroutines.flow.Flow

class MedicationRepository(private val medicationDao: MedicationDao) {

    fun getMedicationsByUser(userId: Int): Flow<List<Medication>> {
        return medicationDao.getMedicationsByUser(userId)
    }

    fun getMedicationById(medicationId: Int): Flow<Medication?> {
        return medicationDao.getMedicationById(medicationId)
    }

    suspend fun insertMedication(medication: Medication): Long {
        return medicationDao.insertMedication(medication)
    }

    suspend fun updateMedication(medication: Medication) {
        medicationDao.updateMedication(medication)
    }

    suspend fun deleteMedication(medication: Medication) {
        medicationDao.deleteMedication(medication)
    }

    suspend fun decreaseStock(medicationId: Int) {
        medicationDao.decreaseStock(medicationId)
    }
}
