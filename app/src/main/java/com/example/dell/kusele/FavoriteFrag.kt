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
        annonce.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        annonce.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        annonce.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        annonce.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        annonce.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        val marcher = ArrayList<Marcher>()
        marcher.add(Marcher("Macdo", annonce,BitmapFactory.decodeResource(context!!.getResources(),R.drawable.kusele)))
        marcher.add(Marcher("Macdo", annonce,BitmapFactory.decodeResource(context!!.getResources(),R.drawable.kusele)))
        marcher.add(Marcher("Macdo", ArrayList<Annonce>(),BitmapFactory.decodeResource(context!!.getResources(),R.drawable.kusele)))
        marcher.add(Marcher("Macdo", annonce,BitmapFactory.decodeResource(context!!.getResources(),R.drawable.kusele)))
        marcher.add(Marcher("Macdo", annonce,BitmapFactory.decodeResource(context!!.getResources(),R.drawable.kusele)))
        var adapter = RecycleMarche(marcher)
        FavoriteRecycle.adapter = adapter
    }
}