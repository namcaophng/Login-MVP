package com.example.mvpdemo.ui.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvpdemo.R
import com.example.mvpdemo.ui.logIn.LoginActivity
import com.example.mvpdemo.ui.logIn.LoginContract
import kotlinx.android.synthetic.main.sign_up.*

class SignUpActivity : AppCompatActivity(), SignUpContract.view {
    override fun onSignUpSuccess(mess: String) {
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onSignUpFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    lateinit var signPresenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        signPresenter = SignUpPresenter(this)
    }

    fun createNew(v: View){
        var user = s_username.text.toString()
        var passw = s_passw.text.toString()

        signPresenter.signUp(user, passw)
    }
}
