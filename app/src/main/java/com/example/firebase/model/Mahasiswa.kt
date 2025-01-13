package com.example.firebase.model

data class Mahasiswa(
    val nim:String,
    val nama:String,
    val alamat:String,
    val gender:String,
    val kelas:String,
    val angkatan:String,
    val judul:String,
    val pembimbing1:String,
    val pembimbing2:String,
) {
    constructor() : this("", "", "", "", "", "", "","","")
}
