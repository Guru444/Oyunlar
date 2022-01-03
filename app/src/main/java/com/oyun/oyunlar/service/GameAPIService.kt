package com.oyun.oyunlar.service

import android.text.BoringLayout
import com.oyun.oyunlar.model.GameListResponse
import com.oyun.oyunlar.model.NobetciEczaneResponse
import com.oyun.oyunlar.model.PazarYerleriResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GameAPIService {

    val baseUrl = "https://openapi.izmir.bel.tr/api/ibb/"

    var retrofitApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GameAPI::class.java)

    fun getGameList() : Single<PazarYerleriResponse>{
        return retrofitApi.getGameTypeList(1,false)
    }
    fun getNobetciEczane() : Single<NobetciEczaneResponse>{
        return retrofitApi.getNobetciEczane()
    }
}