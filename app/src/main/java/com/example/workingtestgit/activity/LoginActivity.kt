package com.example.workingtestgit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.workingtestgit.R

class LoginActivity : AppCompatActivity() {

    var id:String? = null
    var pw:String? = null
    var pwc:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var edtId = findViewById<EditText>(R.id.edtId)
        var edtPw = findViewById<EditText>(R.id.edtPw)
        var edtPwC = findViewById<EditText>(R.id.edtPwC)

        var loginbutton = findViewById<Button>(R.id.btnLogin)

        loginbutton.setOnClickListener(){

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
                startActivity(intent)
            }
        }
    }
}