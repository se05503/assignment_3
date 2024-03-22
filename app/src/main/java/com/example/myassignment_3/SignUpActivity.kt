package com.example.myassignment_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    private lateinit var btnBack : Button
    private lateinit var et_name : EditText
    private lateinit var et_id2 : EditText
    private lateinit var et_password2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnBack = findViewById(R.id.btn_back)
        et_name = findViewById(R.id.et_name)
        et_id2 = findViewById(R.id.et_id2)
        et_password2 = findViewById(R.id.et_password2)
        btnBackClicked() // 추가해야함!(안그럼 버튼 안눌림)
    }

    private fun btnBackClicked() {
        btnBack.setOnClickListener {
            if(et_name.length()==0 || et_id2.length()==0 || et_password2.length()==0) {
                Toast.makeText(this, "정보를 입력해주세요!",Toast.LENGTH_SHORT).show()
            } else {
                // 아이디와 비밀번호 정보를 가지고 다시 SignInActivity로 넘어가야함
                intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id",et_id2.text.toString())
                intent.putExtra("password",et_password2.text.toString())
                setResult(RESULT_OK,intent)
                finish() // 다시 원래 액티비티로 돌아감
            }
        }
    }

}