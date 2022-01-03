package com.oyun.oyunlar.model


import com.google.gson.annotations.SerializedName

class GameListResponse : ArrayList<GameListResponse.GameListResponseItem>(){
    data class GameListResponseItem(
        @SerializedName("tur_id")
        var tur_id: String? = null,
        @SerializedName("tur_ad")
        var tur_ad: String? = null
    )
}