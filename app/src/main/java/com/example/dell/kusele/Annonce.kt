package com.example.dell.kusele

import android.graphics.Bitmap
import android.media.Image
import java.time.LocalDateTime

data class Annonce(val marcherImage: Bitmap, val ProductImage: Bitmap, val id: Int, val nom: String, val PrixAnnouce: Float, val PrixReduce: Float, val DatePost: String, val DateExpire: String, val Quantity: Int) {

}