package br.com.login.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.login.R
import br.com.login.util.SaveSharedPreference

class HomeActivity : AppCompatActivity() {

    private val saveSharedPreference = SaveSharedPreference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun onClickLogout(view: View){
        saveSharedPreference.setLoggedIn(applicationContext, false)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}