package com.example.dell.kusele

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.frag_favorite.*

public class FavoriteFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.frag_favorite, container, false)
        return rootView
    }

    override fun onStart() {
        super.onStart()
        FavoriteRecycle.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        val annonce = ArrayList<Annonce>()
        val marcher = ArrayList<Marcher>()
        var adapter = RecycleMarche(marcher)
        FavoriteRecycle.adapter = adapter
    }
}