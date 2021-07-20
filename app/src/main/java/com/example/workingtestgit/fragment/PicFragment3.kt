package com.example.workingtestgit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.workingtestgit.R
import kotlinx.android.synthetic.main.pic_fragment.*

class PicFragment3 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.pic_fragment3, container, false)

        var pic = view.findViewById<ImageView>(R.id.imgPic3)
        pic.scaleType = ImageView.ScaleType.FIT_XY

        return view
    }

    private fun resize() {

    }
}