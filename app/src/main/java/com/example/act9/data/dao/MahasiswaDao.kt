package com.example.act9.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.act9.data.entity.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa
    )

    @Update
    suspend fun updateMahasiswa(
        mahasiswa: Mahasiswa
    )
}