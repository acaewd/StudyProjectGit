package com.example.workingtestgit.activity

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.workingtestgit.adapter.ProfileAdapter
import com.example.workingtestgit.R
import com.example.workingtestgit.items.Profiles
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    var addButton: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "Jung", 30, "앱 개발자"),
            Profiles(R.drawable.woman, "Kim", 24, "디자이너"),
            Profiles(R.drawable.man, "Lee", 28, "백엔드"),
            Profiles(R.drawable.woman, "Ahn", 34, "웹 개발자"),
            Profiles(R.drawable.man, "Park", 25, "프로그래머"),
            Profiles(R.drawable.woman, "Hong", 31, "프론트엔드")

        )

        // onCreat시 세로 가로 확인
        var orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            rv_profile.layoutManager = GridLayoutManager(this, 4)
        }
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            rv_profile.layoutManager = GridLayoutManager(this, 2)
        }

        //rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) 그냥 리사이클뷰만 사용시
        rv_profile.setHasFixedSize(true)

        val mAdapter = ProfileAdapter(profileList)
        rv_profile.adapter = mAdapter

        if (!addButton) {
            btnOpen.text = "열기"
            rv_profile.visibility = View.GONE
            il_choice.visibility = View.GONE

        } else {
            btnOpen.text = "닫기"
            il_choice.visibility = View.VISIBLE
            rv_profile.visibility = View.VISIBLE
        }

        btnOpen.setOnClickListener() {
            if (!addButton) {
                il_choice.visibility = View.VISIBLE
                rv_profile.visibility = View.VISIBLE
                addButton = true
                btnOpen.text = "닫기"
            } else {
                rv_profile.visibility = View.GONE
                il_choice.visibility = View.GONE
                addButton = false
                btnOpen.text = "열기"
            }
        }

        btnAddInfo.setOnClickListener() {
            mAdapter.additem(Profiles(R.drawable.man, "신입", 20, "신입개발자"))
            mAdapter.notifyDataSetChanged()
        }

        btnRemoveInfo.setOnClickListener() {
            mAdapter.removeitem(mAdapter.getPosition())
            mAdapter.notifyDataSetChanged()
        }

    }

    //세로 가로 화면 전환시 변화
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            rv_profile.layoutManager = GridLayoutManager(this, 2)
        }

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rv_profile.layoutManager = GridLayoutManager(this, 4)
        }

    }
}