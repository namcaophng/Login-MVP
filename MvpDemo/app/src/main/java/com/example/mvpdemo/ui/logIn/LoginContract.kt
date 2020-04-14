package com.example.mvpdemo.ui.logIn

import com.example.mvpdemo.data.User

interface LoginContract {
    interface View{
        fun onLoginSuccess(user: User)

        fun onLoginFailure(error: String)
    }

    interface Presenter{
        fun handleLogin(username: String, pass: String)
    }
}