package com.example.dell.kusele

import android.app.Fragment
import android.content.Intent
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RecycleAnonnce(val produitList: ArrayList<Annonce>) : RecyclerView.Adapter<RecycleAnonnce.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.MarcherImage.setImageResource(produitList[position].marcherImage)
        holder.productImage.setImageResource(produitList[position].ProductImage)
        holder.nom.text = produitList[position].nom
        holder.dateExprire.text = produitList[position].DateExpire
        holder.PrixPost.text = produitList[position].PrixAnnouce.toString()
        holder.prixReduce.text = produitList[position].PrixReduce.toString()
        val intent = Intent(holder.itemView.context,DetailActivity::class.java)
        intent.putExtra("test", produitList[position].nom)
        holder.card.setOnClickListener{
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_home, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return produitList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val MarcherImage = itemView.findViewById<ImageView>(R.id.MarcherImage)
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val nom = itemView.findViewById<TextView>(R.id.nom)
        val dateExprire = itemView.findViewById<TextView>(R.id.dateExprire)
        val PrixPost = itemView.findViewById<TextView>(R.id.PrixPost)
        val prixReduce = itemView.findViewById<TextView>(R.id.prixReduce)
        val card = itemView.findViewById<CardView>(R.id.Card)

    }
}