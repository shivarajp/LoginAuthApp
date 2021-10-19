package com.masai.loginauthapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.loginauthapp.room.LoginDAO
import com.masai.loginauthapp.room.LoginDatabase
import com.masai.loginauthapp.room.LoginEntity
import kotlinx.android.synthetic.main.register_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    lateinit var database: LoginDatabase
    lateinit var dao: LoginDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        database = LoginDatabase.getLoginDatabase(this)
        dao = database.getLoginDAO()

        signUpBtn.setOnClickListener {
            val signUpData = LoginEntity(
                nameEt.text.toString(),
                emailEt.text.toString(),
                ageEt.text.toString().toInt(),
                mobileEt.text.toString().toInt(),
                passwordEt.text.toString()
            )

            CoroutineScope(Dispatchers.IO).launch {
                dao.register(signUpData)
                finish()
            }
        }
    }
}