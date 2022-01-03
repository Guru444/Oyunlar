package com.oyun.oyunlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.SerializedName
import com.oyun.oyunlar.service.GameAPI
import com.oyun.oyunlar.service.GameAPIService
import com.oyun.oyunlar.view.GameListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_open_list.setOnClickListener {
            val intent = Intent(this, GameListActivity::class.java)
            startActivity(intent)
        }

    }
    //MVVM Model - view - ViewModel (LiveData)
}