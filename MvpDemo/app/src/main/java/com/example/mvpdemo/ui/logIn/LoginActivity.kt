package com.example.mvpdemo.ui.logIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvpdemo.R
import com.example.mvpdemo.data.User
import com.example.mvpdemo.ui.signUp.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), View.OnClickListener,
    LoginContract.View {

    companion object{
        var allUsers = ArrayList<User>()
    }


    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerListener()
        presenter = LoginPresenter(this)
    }

    private fun registerListener() {
        buttonlogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonlogin -> handleLogin()
        }
    }

    private fun handleLogin() {
        presenter.handleLogin(username.text.toString(), passw.text.toString())
    }

    fun signUp(v: View) {
        var intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginSuccess(user: User) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailure(error: String) {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
    }
}
