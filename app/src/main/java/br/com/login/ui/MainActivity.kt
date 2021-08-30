package br.com.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import br.com.login.R
import br.com.login.databinding.ActivityMainBinding
import br.com.login.util.SaveSharedPreference
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val saveSharedPreference = SaveSharedPreference()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (saveSharedPreference.getLoggedStatus(this)){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    fun onClick(view: View){
        binding.progressCircular.visibility = View.VISIBLE
        login(findViewById<TextInputEditText>(R.id.edtUserName).text.toString(),
            findViewById<TextInputEditText>(R.id.edtPassword).text.toString())
    }

    private fun login(userName: String, password: String) {
        binding.progressCircular.visibility = View.VISIBLE
        if (userName == "name" && password == "1234"){
            saveSharedPreference.setLoggedIn(applicationContext, true)

            Handler().postDelayed({
                binding.progressCircular.visibility = View.GONE
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 2000)

            Toast.makeText(this, R.string.msg_success_login, Toast.LENGTH_LONG).show()
        } else {
            binding.progressCircular.visibility = View.GONE
            Toast.makeText(this, R.string.msg_fail_login, Toast.LENGTH_LONG).show()
        }
    }
}