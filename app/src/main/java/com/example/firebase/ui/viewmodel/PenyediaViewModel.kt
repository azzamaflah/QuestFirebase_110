package com.example.firebase.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebase.MahasiswaApp

object PenyediaViewModel {

    val Factory = viewModelFactory {
        initializer { HomeViewModel(MahasiswaApp().containerApp.repositoryMhs) }
        initializer { InsertViewModel(MahasiswaApp().containerApp.repositoryMhs) }
    }
}
fun CreationExtras.MahasiswaApp(): MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)