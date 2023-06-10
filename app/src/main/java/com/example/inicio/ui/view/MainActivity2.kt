package com.example.inicio.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio.R
import com.example.inicio.domain.SelectedListener



class MainActivity2 : AppCompatActivity(), SelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onSelected(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null) // agregar al stack para volver con back
            .commit()
    }

}