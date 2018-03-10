package com.example.dell.kusele

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    private var mAuth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart(){
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if(currentUser != null){
            val intent:Intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish()
        }
        SignIn.setOnClickListener {
            mAuth!!.signInWithEmailAndPassword(EmailText.text.toString(), PasswordText.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = mAuth!!.getCurrentUser()
                            if(user != null){
                            val intent:Intent = Intent(this, Main::class.java)
                            startActivity(intent)
                            finish()
                            }else{
                                Toast.makeText(this@Main2Activity, "Probleme de connection",Toast.LENGTH_SHORT).show()
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this@Main2Activity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                        }
                    }
        }
        SignUp.setOnClickListener{
            val intent:Intent = Intent(this, SignUPActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUI(user: FirebaseAuth) {}


}
