package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Ajustes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        MyToolbar().show(this,"actividad2",true)
    }
}