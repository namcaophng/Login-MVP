package com.example.mvpdemo.ui.signUp

interface SignUpContract {

    interface view{
        fun onSignUpSuccess(mess: String)

        fun onSignUpFailure(error: String)
    }

    interface presenter{
        fun signUp(user: String, pass: String)
    }

}