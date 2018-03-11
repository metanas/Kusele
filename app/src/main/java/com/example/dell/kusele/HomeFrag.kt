package com.example.dell.kusele

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

public class HomeFrag() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.frag_home, container, false)
        return rootView
    }

    public class Product(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var id:Int?=null
        var nom:String?=null
        var description:String?=null
        var PrixProduit:Float?=null
        var PrixReduce:Float?=null
        var DatePost: Date?=null
        var DateExpire: Date?=null

    }
}