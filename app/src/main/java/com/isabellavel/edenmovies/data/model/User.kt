package com.isabellavel.edenmovies.data.model

import java.io.Serializable

data class User(val id: String, val uname: String, val uemail: String,
val uisAuth: Boolean, val uisnew: Boolean, val uiscreated: Boolean) : Serializable {
    val uid = ""
    val name = ""
    val email = ""
    val isAuth = false
    val isnew = false
    val iscreated = false

}
