package com.oyun.oyunlar.service

import android.util.Log
import android.widget.Toast
import com.oyun.oyunlar.model.GameListResponse
import com.oyun.oyunlar.model.NobetciEczaneResponse
import com.oyun.oyunlar.model.PazarYerleriResponse
import io.reactivex.Single
import retrofit2.http.*

interface GameAPI {
    companion object {
        const val PAZAR_YERLERI = "api/v2/selling/{id}"
        const val NOBETCI_ECZANE = "nobetcieczaneler"
    }

    //gameType/10 -> Path
    //gameType?=1 -> Query
    //{
    // gameType: 1 -> Body
    // }https://test-mobil-api.kocailem.com/api/v2/selling/60/false

    @GET(PAZAR_YERLERI)
    fun getGameTypeList(@Path("id") ilanId: Int, @Query("isMobile") isMobile: Boolean) : Single<PazarYerleriResponse>

    @GET(NOBETCI_ECZANE)
    fun getNobetciEczane() : Single<NobetciEczaneResponse>

}