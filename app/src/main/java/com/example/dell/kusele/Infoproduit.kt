package com.example.dell.kusele

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_infoproduit.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Infoproduit : AppCompatActivity() {
    val ONE_MEGABYTE = (1024 * 1024).toLong()
    var img:String?=null
    private var mDatabase: DatabaseReference? = null
    private var storage: FirebaseStorage?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infoproduit)
        img = intent.getStringExtra("w")
        storage = FirebaseStorage.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference();


        submit.setOnClickListener {
            mDatabase!!.child("annonces").child("a5").child("commerce").setValue("acima")
            mDatabase!!.child("annonces").child("a5").child("date_added").setValue("${ajout.text}")
            mDatabase!!.child("annonces").child("a5").child("date_exp").setValue("${avant.text}")
            mDatabase!!.child("annonces").child("a5").child("link").setValue("${img}")
            mDatabase!!.child("annonces").child("a5").child("nom").setValue("${newproduit.text}")
            mDatabase!!.child("annonces").child("a5").child("prix").setValue("${prix.text}")
            mDatabase!!.child("annonces").child("a5").child("prix_old").setValue("${newP.text}")
            mDatabase!!.child("annonces").child("a5").child("qte").setValue("${qte.text}")

            finish()

        }
    }

    override fun onStart() {
        super.onStart()
        val storageRef = storage!!.getReference()
        val mountainsRef = storageRef.child(img!!)
        mountainsRef.getBytes(ONE_MEGABYTE).addOnSuccessListener {
            // Data for "images/island.jpg" is returns, use this as needed
            val im = BitmapFactory.decodeByteArray(it,0, it.size)
            photo.setImageBitmap(im)
        }.addOnFailureListener {
                    // Handle any errors
                };

    }

}
