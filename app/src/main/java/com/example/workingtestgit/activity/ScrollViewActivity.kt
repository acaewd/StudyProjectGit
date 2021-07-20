package com.example.workingtestgit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.workingtestgit.R
import com.example.workingtestgit.fragment.PicFragment1
import com.example.workingtestgit.fragment.PicFragment2
import com.example.workingtestgit.fragment.PicFragment3
import kotlinx.android.synthetic.main.activity_scroll_view.*

class ScrollViewActivity : AppCompatActivity() {

    var picNumber:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        setFrag(0)

        //resizeImage()

        var nextButton2 = findViewById<Button>(R.id.btnNext2)

        nextButton2.setOnClickListener(){
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener(){
            super.onBackPressed()
        }

        btnChange.setOnClickListener(){
            if (picNumber == 0){
                picNumber = 1
                setFrag(1)
            } else if(picNumber == 1){
                picNumber = 2
                setFrag(2)
            } else if(picNumber == 2){
                picNumber = 0
                setFrag(0)
            }
        }

    }

    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, PicFragment1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, PicFragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, PicFragment3()).commit()
            }
        }

    }

    fun resizeImage(){
        //imageView.scaleType = ImageView.ScaleType.FIT_XY
        //imageView2.scaleType = ImageView.ScaleType.FIT_XY
        //imageView3.scaleType = ImageView.ScaleType.FIT_XY
    }
}