package com.example.inicio

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.ScaleAnimation



import android.widget.TextView

import com.example.inicio.databinding.ActivityAcercaDeBinding



class AcercaDe : AppCompatActivity() {

    lateinit var binding :ActivityAcercaDeBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)


        binding=ActivityAcercaDeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyToolbar().show(this,"acerca de",true)




    /*binding.acerRegresar.setOnClickListener(){
    val intent=Intent(this@AcercaDe,MainActivity::class.java)
    startActivity(intent)
}*/



 /*val regresar = findViewById<Button>(R.id.acer_regresar) as Button

       regresar.setOnClickListener{
           val intent= Intent ( this@AcercaDe,MainActivity::class.java)
           startActivity(intent)

       }*/
        /*------Animaciones de las letras como ser el titulo y los parrafos------*/
        val textView1 = findViewById<TextView>(R.id.texttitle)

    val anim = ScaleAnimation(0f, 1f, 0f, 1f)
    anim.duration = 10000 // Duración de la animación en milisegundos
    textView1.startAnimation(anim)


        val textView2= findViewById<TextView>(R.id.textparraf)

        val anim2 = ScaleAnimation(0f, 1f, 0f, 1f)
        anim2.duration = 10000 // Duración de la animación en milisegundos
        textView2.startAnimation(anim2)
/*----------------------------------------------------------------------------*/

    }
}