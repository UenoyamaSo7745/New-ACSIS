package com.acsis.medicamentos.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.acsis.medicamentos.service.MedicationReminderService

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent != null) {
            val medicationId = intent.getIntExtra("medication_id", -1)
            if (medicationId != -1) {
                val serviceIntent = Intent(context, MedicationReminderService::class.java)
                serviceIntent.putExtra("medication_id", medicationId)
                context.startService(serviceIntent)
            }
        }
    }
}
