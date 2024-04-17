package com.example.itfrister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var password: EditText? = null
    private var confirmPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.btn_submit)
        password = findViewById<EditText>(R.id.new_password)
        confirmPassword = findViewById<EditText>(R.id.confirm_password)

        button?.setOnClickListener {
            if (password?.text.toString() != "" && password?.text.toString() == confirmPassword?.text.toString() && password?.text.toString().length > 7) {
                val intent = Intent(this, VerifyActivity::class.java)
                startActivity(intent)
            } else if(password?.text.toString() == confirmPassword?.text.toString()) {
                Toast.makeText(this, "Password is too short or empty", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Those passwords didn’t match. Try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}