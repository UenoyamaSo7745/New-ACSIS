package com.acsis.medicamentos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acsis.medicamentos.data.dao.MedicationDao
import com.acsis.medicamentos.data.dao.MedicationHistoryDao
import com.acsis.medicamentos.data.dao.MedicationReminderDao
import com.acsis.medicamentos.data.dao.UserDao
import com.acsis.medicamentos.data.entity.Medication
import com.acsis.medicamentos.data.entity.MedicationHistory
import com.acsis.medicamentos.data.entity.MedicationReminder
import com.acsis.medicamentos.data.entity.User

@Database(
    entities = [
        User::class,
        Medication::class,
        MedicationReminder::class,
        MedicationHistory::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ACBDDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun medicationDao(): MedicationDao
    abstract fun medicationReminderDao(): MedicationReminderDao
    abstract fun medicationHistoryDao(): MedicationHistoryDao

    companion object {
        @Volatile
        private var instance: ACBDDatabase? = null

        fun getInstance(context: Context): ACBDDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ACBDDatabase::class.java,
                    "acsis_database"
                ).build().also { instance = it }
            }
        }
    }
}
