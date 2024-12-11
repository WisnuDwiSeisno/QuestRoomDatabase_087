package com.example.act9.dependeciesinjection

import android.content.Context
import com.example.act9.data.database.KrsDatabase
import com.example.act9.repository.LocalRepositoryMhs
import com.example.act9.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}