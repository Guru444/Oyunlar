package com.oyun.oyunlar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oyun.oyunlar.R
import com.oyun.oyunlar.adapter.GameListAdapter
import com.oyun.oyunlar.service.GameAPIService
import com.oyun.oyunlar.viewmodel.GameListViewModel
import kotlinx.android.synthetic.main.activity_game_list.*

class GameListActivity : AppCompatActivity() {

    private var gameListViewModel = GameListViewModel()
    var gameAdapter = GameListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)

        gameListViewModel = ViewModelProvider(this).get(GameListViewModel::class.java)

        gameListViewModel.getGameList()

        gameListViewModel.getNobetciEczane()

        gameListViewModel.gameListLivedata.observe(this, Observer { cevap->
            //gameAdapter.getData(cevap.onemliyer!!)
        })

        gameListViewModel.nobetciEczaneLivedata.observe(this, Observer { eczane->
            gameAdapter.setData(eczane)
        })

        var gameList: ArrayList<String> = arrayListOf()
        gameList.add("LOL")
        gameList.add("PUBG")
        gameList.add("CS 1.6")
        gameList.add("CS 1.3")
        gameList.add("CS 1.5")
        gameList.add("CS 1.1")
        gameList.add("CS 1.3")
        gameList.add("CS GO")

        rv_gamelist.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        rv_gamelist.adapter = gameAdapter



    }
}