package com.example.mvpdemo.ui.signUp

import com.example.mvpdemo.data.User
import com.example.mvpdemo.ui.logIn.LoginActivity.Companion.allUsers

class SignUpPresenter(var view: SignUpContract.view): SignUpContract.presenter {

    override fun signUp(user: String, pass: String) {
        var new = User(user, pass)
        var f = true
        allUsers.forEach {
            var user = it.username
            var pass = it.passw
            if (user.contentEquals(new.username)){
                f = false
            }
        }
        if(f){
            allUsers.add(new)
            view.onSignUpSuccess("Sign up successfully!")
        }else{
            view.onSignUpFailure("This username existed!")
        }
    }

}