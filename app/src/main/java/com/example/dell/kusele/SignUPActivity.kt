package com.example.dell.kusele

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUPActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()
        Sinscrire.setOnClickListener({
            createUser()
        })

    }

    fun createUser() {
        mAuth!!.createUserWithEmailAndPassword(textEmail.text.toString(), textPassword.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val intent = Intent(this, Main::class.java)
                        startActivity(intent)
                        finish()


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this@SignUPActivity, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }

                }
    }

}
