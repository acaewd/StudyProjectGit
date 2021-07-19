package com.example.workingtestgit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.workingtestgit.R

class UserPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_pg)

        val Id = intent.getStringExtra("Id").toString()
        val Pw = intent.getStringExtra("Pw").toString()

        var checkButton = findViewById<Button>(R.id.btnCheck)

        var nextButton = findViewById<Button>(R.id.btnNext)

        checkButton.setOnClickListener(){
            Log.d("아이디:", Id)
            Log.d( "비밀번호:", Pw)
        }

        nextButton.setOnClickListener(){
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }

    }
}