package com.example.mvpdemo.ui.logIn

import com.example.mvpdemo.data.User
import com.example.mvpdemo.ui.logIn.LoginActivity.Companion.allUsers

class LoginPresenter(var view: LoginContract.View):
    LoginContract.Presenter {

    override fun handleLogin(username: String, pass: String) {
        var f = false
        var use= User("", "")
        allUsers.forEach {
            var user = it.username
            var pas = it.passw
            if (username.contentEquals(user) && pass.contentEquals(pas)){
                use = User(username, pass)
                f = true
            }
        }
        if(f){
            view.onLoginSuccess(use)
        }
        else if (username.isEmpty() || pass.isEmpty()){
            view.onLoginFailure("Username or Password is empty!")
        }
        else{
            view.onLoginFailure("Login Failure!")
        }
    }
}