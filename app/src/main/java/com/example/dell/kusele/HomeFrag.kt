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
import kotlinx.android.synthetic.main.frag_home.*

public class HomeFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.frag_home, container, false)
        return rootView
    }

    override fun onStart() {
        super.onStart()

        HomeRecycle.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        val users = ArrayList<Annonce>()
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
        ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))
        users.add(Annonce(BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), BitmapFactory.decodeResource(context!!.getResources(),
                R.drawable.kusele), 1,"produit1",200f,100f, "2-10-2018","5-10-2018"
                ,10))

        var adapter = RecycleAnonnce(users)
        HomeRecycle.adapter = adapter
    }
}