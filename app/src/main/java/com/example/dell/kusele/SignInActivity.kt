package com.example.dell.kusele

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.sign_in.*
import com.google.firebase.database.DatabaseError


public class SignInActivity : Fragment() {

    private var mGoogleSignInClient: GoogleSignInClient? = null
    private val RC_SIGN_IN = 9001
    private var mAuth: FirebaseAuth? = null
    var rootView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.sign_in, container, false)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(activity!!.baseContext, gso)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if (currentUser != null) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        seconnecter.setOnClickListener({
            LoginUser()
        })

        CNWG.setOnClickListener {
            signIn()
        }
    }

    private fun LoginUser() {
        if (!EmailTexts.text.isEmpty() && !PasswordTexts.text.isEmpty())
            mAuth!!.createUserWithEmailAndPassword(EmailTexts.text.toString(), PasswordTexts.text.toString())
                    .addOnCompleteListener(activity!!, OnCompleteListener<AuthResult> { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = mAuth!!.getCurrentUser()
                            startActivity(Intent(activity, MainActivity::class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(activity, "email ou le mot de passe est incorrect", Toast.LENGTH_SHORT).show()
                        }

                    })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
            }

        }
    }


    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity!!) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth!!.currentUser
                        val mRef = FirebaseDatabase.getInstance().reference
                        var intent: Intent? = null
                        mRef.child("clients").child(user!!.uid).addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    intent = Intent(activity, MainActivity::class.java)
                                } else {
                                    intent = Intent(activity, Choose::class.java)
                                }
                                startActivity(intent)
                            }

                            override fun onCancelled(databaseError: DatabaseError) {

                            }
                        })
                    }
                }
    }

    private fun signIn() {
        val intent = mGoogleSignInClient!!.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN)
    }

}