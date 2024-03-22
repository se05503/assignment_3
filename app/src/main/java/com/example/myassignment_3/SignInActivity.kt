package com.example.myassignment_3

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var et_id: EditText
    private lateinit var et_password: EditText
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_id = findViewById(R.id.et_id)
        et_password = findViewById(R.id.et_password)
        setResultSignUp()
    }

    private fun setResultSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val id = result.data?.getStringExtra("id") ?: ""
                    val password = result.data?.getStringExtra("password") ?: ""
                    et_id.setText(id)
                    et_password.setText(password)
                }
            }
    }

    fun btnOnClicked(view: View) {
        val data_id = et_id.text.toString()
        val data_password = et_password.text.toString()

        when (view.id) {
            R.id.btn_login -> {
                if (data_id.equals("") || data_password.equals("")) {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "로그인 성공하셨습니다!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("id", data_id)
                    startActivity(intent)
                }
            }

            R.id.btn_join -> {
                val intent = Intent(this, SignUpActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}

