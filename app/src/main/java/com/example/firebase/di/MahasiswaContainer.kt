package com.example.firebase.di

import com.example.firebase.repository.RepositoryMhs
import android.content.Context
import com.example.firebase.repository.NetworkRepositoryMhs
import com.google.firebase.firestore.FirebaseFirestore

interface InterfaceContainerApp{
    val repositoryMhs : RepositoryMhs
}

class MahasiswaContainer(private val context: Context) :InterfaceContainerApp{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositoryMhs: RepositoryMhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}