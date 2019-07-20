package com.itrocket.hackaton.model.data.storage

import android.content.Context

class Prefs constructor(
    private val context: Context
) {

    private fun getSharedPreferences(prefsName: String) =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    //region auth
    private val AUTH_DATA = "auth_data"
    private val KEY_ACCESS_TOKEN = "access_token"
    private val authPrefs by lazy { getSharedPreferences(AUTH_DATA) }

    var accessToken : String?
        get() = authPrefs.getString(KEY_ACCESS_TOKEN, null)
        set(value) {
            authPrefs.edit().putString(KEY_ACCESS_TOKEN, value).apply()
        }
    //endregion
}
