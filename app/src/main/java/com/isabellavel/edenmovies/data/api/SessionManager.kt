package com.isabellavel.edenmovies.data.api

import android.content.Context
import android.content.SharedPreferences
import com.isabellavel.edenmovies.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        val USER_TOKEN = "user token"
    }
    //save token
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    //fetch token
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}