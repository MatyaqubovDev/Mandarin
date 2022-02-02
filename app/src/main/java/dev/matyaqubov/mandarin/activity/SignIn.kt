package dev.matyaqubov.mandarin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import dev.matyaqubov.mandarin.R
import java.util.regex.Pattern

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initViews()
    }

    private fun initViews() {

        val et_email=findViewById<EditText>(R.id.et_email)
        et_email.addTextChangedListener {
            if (isValied(it.toString())){
                et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.ic_check, 0);
            } else{
                et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,R.drawable.ic_error, 0);

            }
        }
    }

    private fun isValied(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}