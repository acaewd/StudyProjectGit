package com.example.workingtestgit.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.workingtestgit.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var id:String? = null
    var pw:String? = null
    var pwc:String? = null

    var backWait:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEnd.setOnClickListener(){
            finish()
        }

        var edtId = findViewById<EditText>(R.id.edtId)
        var edtPw = findViewById<EditText>(R.id.edtPw)
        var edtPwC = findViewById<EditText>(R.id.edtPwC)

        btnLogin.setOnClickListener(){

            id = edtId.text.toString().trim()
            pw = edtPw.text.toString().trim()
            pwc = edtPwC.text.toString().trim()

            if(id.equals("")){
                Toast.makeText(this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show()
            } else if(pw.equals("")){
                Toast.makeText(this, "패스워드를 입력하세요", Toast.LENGTH_SHORT).show()
            } else if(pwc.equals("")){
                Toast.makeText(this, "패스워드확인을 입력하세요", Toast.LENGTH_SHORT).show()
            } else if(!pw.equals(pwc)){
                Toast.makeText(this, "패스워드를 확인하세요", Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(this, UserPgActivity::class.java)
                intent.putExtra("Id",id)
                intent.putExtra("Pw",pw)
                edtId.setText("")
                edtPw.setText("")
                edtPwC.setText("")
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - backWait >=2000){
            backWait = System.currentTimeMillis()
            Toast.makeText(this, "한번더 누를시 앱종료", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
    }
}