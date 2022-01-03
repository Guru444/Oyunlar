package com.oyun.oyunlar.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.oyun.oyunlar.adapter.GameListAdapter
import com.oyun.oyunlar.model.GameListResponse
import com.oyun.oyunlar.model.NobetciEczaneResponse
import com.oyun.oyunlar.model.PazarYerleriResponse
import com.oyun.oyunlar.service.GameAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GameListViewModel : ViewModel() {

    private var gameAPIService = GameAPIService() // Servisimizi tanımladık.

    //LiveDatalarımızı tanımladık.
    val gameListLivedata: MutableLiveData<PazarYerleriResponse> = MutableLiveData<PazarYerleriResponse>()
    val nobetciEczaneLivedata: MutableLiveData<NobetciEczaneResponse> = MutableLiveData<NobetciEczaneResponse>()

    @SuppressLint("CheckResult")
    fun getGameList(){
        gameAPIService.getGameList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<PazarYerleriResponse>() {
                override fun onSuccess(response: PazarYerleriResponse) {
                    gameListLivedata.value = response
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

    @SuppressLint("CheckResult")
    fun getNobetciEczane(){
        //Thread - iş parçalıkları -  RxJava
        gameAPIService.getNobetciEczane()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<NobetciEczaneResponse>() {
                override fun onSuccess(response: NobetciEczaneResponse) {
                    nobetciEczaneLivedata.value = response
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }
}