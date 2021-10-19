package com.masai.loginauthapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.masai.loginauthapp.room.LoginDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = LoginDatabase.getLoginDatabase(this).getLoginDAO()

        signUpBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        signInBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
               val user = dao.getUser(emailEt.text.toString(), passwordEt.text.toString())

                if (user.email.isNotEmpty()){
                    Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
}