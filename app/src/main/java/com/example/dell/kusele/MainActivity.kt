package com.example.dell.kusele

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import android.support.annotation.NonNull
import java.lang.reflect.Array.getByte


class MainActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var REQUEST_IMAGE_CAPTURE: Int = 0
    val MY_CAMERA_PERMETION = 12
    var mAuth: FirebaseAuth? = null
    private var storage: FirebaseStorage? = null
    private var storageReference: StorageReference? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        Camera.setOnClickListener {
            openCamera()
        }
        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        container.setCurrentItem(1)
        storage = FirebaseStorage.getInstance()
    }

    val One_Mega: Long = 200 * 200
    override fun onStart() {
        super.onStart()
        val user = mAuth!!.currentUser
        if (user == null) {
            startActivity(Intent(this, Main2Activity::class.java))
            finish()
        }
        val storageReference = storage!!.getReference()

        val Ref = storageReference.child("Jahmati.jpg")

        val t = Ref.getBytes(One_Mega).addOnSuccessListener(OnSuccessListener<ByteArray> {
            // Data for "images/island.jpg" is returns, use this as needed
            val h = BitmapFactory.decodeByteArray(it, 0, it.size)
            Camera.setImageBitmap(h)
        }).addOnFailureListener(OnFailureListener {
            // Handle any errors
        })

        Toast.makeText(this, Ref.path, Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun openCamera() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)


        } else {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)) {

            }

            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    MY_CAMERA_PERMETION)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data.extras
            val imageBitmap = extras!!.get("data") as Bitmap
            val storageReference = storage!!.getReference()
            val Ref = storageReference.child("")
            val baos = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val data = baos.toByteArray()

            val uploadTask = Ref.putBytes(data)
            uploadTask.addOnFailureListener(OnFailureListener {
                // Handle unsuccessful uploads
            }).addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                val downloadUrl = taskSnapshot.downloadUrl
                val tent = Intent(this, Infoproduit::class.java)
                (downloadUrl.toString())

            })
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_CAMERA_PERMETION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, 0)
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
                return
            }

        // Add other 'when' lines to check for other
        // permissions this app might request.

            else -> {
                // Ignore all other requests.
            }
        }
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            var tab: Fragment
            when (position) {
                0 -> {
                    tab = MapFrag()
                }
                1 -> {
                    tab = HomeFrag()
                }
                2 -> {
                    tab = FavoriteFrag()
                }
                else -> tab = HomeFrag()

            }
            return tab
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }

    }

}
