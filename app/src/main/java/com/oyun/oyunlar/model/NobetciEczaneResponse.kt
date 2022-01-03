package com.oyun.oyunlar.model


import com.google.gson.annotations.SerializedName

class NobetciEczaneResponse : ArrayList<NobetciEczaneResponse.NobetciEczaneResponseItem>(){
    data class NobetciEczaneResponseItem(
        @SerializedName("Adi")
        var adi: String? = null,
        @SerializedName("Adres")
        var adres: String? = null,
        @SerializedName("Bolge")
        var bolge: String? = null,
        @SerializedName("BolgeAciklama")
        var bolgeAciklama: String? = null,
        @SerializedName("BolgeId")
        var bolgeId: Int? = null,
        @SerializedName("EczaneId")
        var eczaneId: Int? = null,
        @SerializedName("IlceId")
        var ilceId: Int? = null,
        @SerializedName("LokasyonX")
        var lokasyonX: String? = null,
        @SerializedName("LokasyonY")
        var lokasyonY: String? = null,
        @SerializedName("Tarih")
        var tarih: String? = null,
        @SerializedName("Telefon")
        var telefon: String? = null,
        @SerializedName("UzaklikMetre")
        var uzaklikMetre: Any? = null
    )
}