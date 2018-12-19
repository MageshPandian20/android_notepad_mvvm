package com.example.esamohammed.mvvm.common

import android.content.Context
import android.content.SharedPreferences
import com.example.esamohammed.notepadmvvm.R


class SharedPref {

    private fun getPreferenceInstance(context: Context): SharedPreferences? {
        if (preference != null) {
            return preference
        } else {
            preference = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
            return preference
        }
    }

    fun setSharedValue(context: Context, key: String, value: String?) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun onClearSingleItem(context: Context, key: String) {
        if (preference != null) {
            val editor = preference!!.edit()
            editor.remove(key)
            editor.commit()
        }
    }


    fun onClearAllPreferences(context: Context) {
        val preferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        //SharedPreferences preferences = context.getSharedPreferences("PREFERENCE", 0);
        val editor = preferences.edit()
        editor.clear()
        editor.commit()
    }


    /**
     * Set the Integer value in the shared preference W.R.T the given key.
     *
     * @param context Context of current state of the application/object
     * @param key     String used as a key for accessing the value.
     * @param value   Integer value which is to be stored in shared preference.
     */

    fun setSharedValue(context: Context, key: String, value: Int) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putInt(key, value)
        editor.commit()
    }

    fun clearSharedValue(context: Context) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.clear()
        editor.commit()
    }

    /**
     * Set the boolean value in the shared preference W.R.T the given key.
     *
     * @param context Context of current state of the application/object
     * @param key     String used as a key for accessing the value.
     * @param value   Boolean value which is to be stored in shared preference.
     */

    fun setSharedValue(context: Context, key: String, value: Boolean?) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }

    /**
     * Returns Boolean value for the given key.
     * By default it will return "false".
     *
     * @param context Context of current state of the application/object
     * @param key     String used as a key for accessing the value.
     * @return false by default; returns the Boolean value for the given key.
     */

    fun getBooleanValue(context: Context, key: String): Boolean? {
        return getPreferenceInstance(context)!!.getBoolean(key, false)
    }

    /**
     * Returns Integer value for the given key.
     * By default it will return "-1".
     *
     * @param context Context of current state of the application/object
     * @param key     String used as a key for accessing the value.
     * @return -1 by default; returns the Integer value for the given key.
     */

    fun getIntValue(context: Context, key: String): Int {
        return getPreferenceInstance(context)!!.getInt(key, -1)
    }


    /**
     * Returns String value for the given key.
     * By default it will return null.
     *
     * @param context Context of current state of the application/object
     * @param key     String used as a key for accessing the value.
     * @return null by default; returns the String value for the given key.
     */

    fun getStringValue(context: Context, key: String): String? {
        return getPreferenceInstance(context)!!.getString(key, "")
    }

    fun setSharedIntData(key: String, value: Int) {
        val editor = preference!!.edit()
        editor.putInt(key, value)
        editor.commit()
    }


    fun setSharedStringData(key: String, value: String) {
        val editor = preference!!.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getSharedStringData(key: String): String? {
        return preference!!.getString(key, null)
    }

    fun getSharedIntData(key: String): Int {
        return preference!!.getInt(key, 0)
    }

    companion object {

        // Single ton objects...
        private var preference: SharedPreferences? = null
        private var sharedPref: SharedPref? = null

        //Single ton method for this class...
        val instance: SharedPref
            get() {
                if (sharedPref != null) {
                    return sharedPref as SharedPref
                } else {
                    sharedPref = SharedPref()
                    return sharedPref as SharedPref
                }
            }
    }
}
