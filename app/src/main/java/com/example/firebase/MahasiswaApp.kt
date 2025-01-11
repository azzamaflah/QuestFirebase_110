package com.example.firebase

import android.app.Application
import com.example.firebase.di.MahasiswaContainer

class MahasiswaApp : Application(){
    lateinit var containerApp: MahasiswaContainer
    override fun onCreate(){
        super.onCreate()
        containerApp = MahasiswaContainer(this)
    }
}