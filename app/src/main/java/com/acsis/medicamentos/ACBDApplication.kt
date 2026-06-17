package com.acsis.medicamentos

import android.app.Application
import com.acsis.medicamentos.data.database.ACBDDatabase

class ACBDApplication : Application() {
    companion object {
        lateinit var database: ACBDDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = ACBDDatabase.getInstance(this)
    }
}
