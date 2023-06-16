package com.example.inicio

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.inicio.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot


class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup
        setup()


    }

    private fun setup(){

        title ="autenticacion"
        binding.butoonregistrar.setOnClickListener {

            if (binding.text1.text.isNotEmpty() && binding.text2.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.appCompatEditText.text.toString(),binding.appCompatEditText2.text.toString())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            showHome()

                        }else{
                            showAlert()
                        }
                    }

            }
        }
        binding.butooningresar.setOnClickListener {

            if (binding.text1.text.isNotEmpty() && binding.text2.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.appCompatEditText.text.toString(),binding.appCompatEditText2.text.toString())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            showHome()

                        }else{
                            showAlert()
                        }
                    }

            }
        }

    }
    private fun showAlert(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se a producido un error al autenticarse")
        builder.setPositiveButton("Aceptar",null)
        val Dialog: AlertDialog = builder.create()
        Dialog.show()
    }
    private fun showHome(){
        val homeIntent= Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}