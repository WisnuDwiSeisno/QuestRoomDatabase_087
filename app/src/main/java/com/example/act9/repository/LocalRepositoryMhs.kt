package com.example.act9.repository

import com.example.act9.data.dao.MahasiswaDao
import com.example.act9.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
    override fun getAllMhs(): Flow<List<Mahasiswa>> =
        mahasiswaDao.getAllMahasiswa()
    override fun getMhs(nim: String): Flow<Mahasiswa> =
        mahasiswaDao.getMahasiswa(nim)
}