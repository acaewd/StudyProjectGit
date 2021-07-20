package com.example.workingtestgit.activity

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.workingtestgit.R
import kotlinx.android.synthetic.main.activity_scroll_view.*

class ScrollViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        resizeImage()

        var nextButton2 = findViewById<Button>(R.id.btnNext2)

        nextButton2.setOnClickListener(){
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener(){}
        super.onBackPressed()
    }

    fun resizeImage(){
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        imageView2.scaleType = ImageView.ScaleType.FIT_XY
        imageView3.scaleType = ImageView.ScaleType.FIT_XY
    }
}