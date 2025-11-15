package com.example.quizapp.data

import android.content.Context

class UserPrefs(context: Context) {
    private val prefs = context.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)

    fun saveUser(email: String, pass: String) {
        prefs.edit().putString("email", email).putString("pass", pass).apply()
    }

    fun login(email: String, pass: String): Boolean {
        return prefs.getString("email", "") == email && prefs.getString("pass", "") == pass
    }
}
