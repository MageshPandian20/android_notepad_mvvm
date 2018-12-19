package com.example.esamohammed.mvvm.util

interface Constants {
    interface NavigationFlag {
        companion object {
            const val NAVIGATE_TO_ADDNOTES = 2000
            const val NAVIGATE_TO_HOMEACTIVITY = 2001
            const val NAVIGATE_TO_SIGNUPACTIVITY = 2002
            const val NAVIGATE_TO_LOGINACTIVITY = 2003
        }
    }

    interface EventFlags {
        companion object {
            const val REFRESH_NOTESLIST = 2
        }
    }

    interface UIEventFlags {
        companion object {
            const val SHOW_TOAST = 1000
            const val SHOW_PROGRESS_BAR = 1001
            const val DISMISS_PROGRESS_BAR = 1002
            const val SHOW_NO_INTERNET = 1003
        }
    }

 interface APIIDS {
        companion object {
            const val SIGNUP = 1000L
            const val LOGIN = 1001L
            const val LISTNOTES = 1002L
            const val CREATENOTES = 1003L
            const val EDITNOTES = 1004L
        }
    }


 interface PreferenceKeys {
        companion object {
            const val AUTH_TOKEN = "AUTH_TOKEN"
            const val IS_LOGGEDIN = "IS_LOGGEDIN"
        }
    }


}