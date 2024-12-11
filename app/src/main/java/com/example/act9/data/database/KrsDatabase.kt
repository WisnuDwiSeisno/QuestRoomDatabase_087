package com.example.act9.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.act9.data.dao.MahasiswaDao
import com.example.act9.data.entity.Mahasiswa

// Mendefinisikan database dengan tabel Mahasiswa
@Database(entities = [Mahasiswa::class /* masukin disini untuk manggil entitas */], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {
    // Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile // Memastikan bahwa nilai variabel Instance selalu sama di semua Thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, // Class Database
                    "KrsDatabase" //Nama Database
                )
                    .build().also { Instance = it }
            })
        }
    }
}