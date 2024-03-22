package com.example.myassignment_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    lateinit var iv_character : ImageView
    val characterArray = arrayOf(
        R.drawable.character3,
        R.drawable.character4,
        R.drawable.character5,
        R.drawable.character6,
        R.drawable.character7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnBack = findViewById<Button>(R.id.btn_back2)
        val tv_id = findViewById<TextView>(R.id.tv_id2)
        iv_character = findViewById(R.id.iv_character)

        val data = intent.getStringExtra("id") // 아이디 받아옴
        tv_id.text = "아이디 : ${data}"

        setRandomImage(iv_character)

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setRandomImage(imageview:ImageView) {
        val randomImageIndex = (characterArray.indices).random()
        val randomImageResource = characterArray[randomImageIndex]
        imageview.setImageResource(randomImageResource)
    }
}