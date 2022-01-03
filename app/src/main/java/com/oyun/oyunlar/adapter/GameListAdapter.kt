package com.oyun.oyunlar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oyun.oyunlar.R
import com.oyun.oyunlar.model.NobetciEczaneResponse
import kotlinx.android.synthetic.main.game_list_item_layout.view.*

class GameListAdapter: RecyclerView.Adapter<GameListAdapter.GameListHolder>() {
    var nobetciEczaneList: ArrayList<NobetciEczaneResponse.NobetciEczaneResponseItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListAdapter.GameListHolder =
        GameListHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.game_list_item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: GameListAdapter.GameListHolder, position: Int) {
        holder.bind(nobetciEczaneList[position])
    }

    override fun getItemCount(): Int = nobetciEczaneList.size

    inner class GameListHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(isim: NobetciEczaneResponse.NobetciEczaneResponseItem) {
            itemView.tv_game_name.text = isim.adi
        }
    }

    fun setData(eczaneResponse: ArrayList<NobetciEczaneResponse.NobetciEczaneResponseItem>){
        nobetciEczaneList.addAll(eczaneResponse)
        notifyDataSetChanged()
    }
}