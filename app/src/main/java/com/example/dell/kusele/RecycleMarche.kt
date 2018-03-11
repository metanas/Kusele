package com.example.dell.kusele

import android.app.ActionBar
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.view.ViewGroup.MarginLayoutParams
import android.widget.RelativeLayout


class RecycleMarche(val MarchanList: ArrayList<Marcher>) : RecyclerView.Adapter<RecycleMarche.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_favorite, parent, false)
        return RecycleMarche.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MarchanList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.MarcherImage.setImageBitmap(MarchanList[position].logo)
        holder.notife.text = "${MarchanList[position].nom} a "
        val s = if(MarchanList[position].offre.size > 1)  "s" else ""
        holder.prod.text = " ${MarchanList[position].offre.size} offre$s"
        for (i in 0..MarchanList[position].offre.size - 1) {
            if (i >= 4) {
                val t = ImageView(holder.itemView.context)
                t.layoutParams = ViewGroup.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT)
                val marginParams = MarginLayoutParams(t.layoutParams)
                marginParams.setMargins(0, 20, 20, 0)
                val layoutParams = RelativeLayout.LayoutParams(marginParams)
                t.layoutParams = layoutParams
                val imgResId = R.drawable.dot3
                t.setImageResource(imgResId)
                holder.layoutParent.addView(t)
                break
            }
            val t = ImageView(holder.itemView.context)
            t.layoutParams = ViewGroup.LayoutParams(150, LinearLayout.LayoutParams.MATCH_PARENT)
            val marginParams = MarginLayoutParams(t.layoutParams)
            marginParams.setMargins(0, 20, 20, 0)
            val layoutParams = RelativeLayout.LayoutParams(marginParams)
            t.layoutParams = layoutParams
            val imgResId = R.drawable.pain
            t.setImageResource(imgResId)
            holder.layoutParent.addView(t)


        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val MarcherImage = itemView.findViewById<ImageView>(R.id.ImageMarcher)
        val notife = itemView.findViewById<TextView>(R.id.march)
        val prod = itemView.findViewById<TextView>(R.id.prod)
        val layoutParent = itemView.findViewById<LinearLayout>(R.id.sumileContent)
    }
}