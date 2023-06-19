package com.example.inicio.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio.R
import com.example.inicio.data.domain.SelectedListener



class MainActivity2 : AppCompatActivity(), SelectedListener {
    /*actividad principal de la aplicación. La actividad implementa la interfaz SelectedListener, que se utiliza para recibir
    la notificación de que se ha seleccionado un Pokémon en el fragmento ListFragment.*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onSelected(id: Int) {
        /*El método onSelected se implementa para manejar la selección de un Pokémon.
    Se crea un Bundle y se le agrega el ID del Pokémon seleccionado. Luego se crea una instancia del
    fragmento DetailFragment y se le asigna el Bundle como argumento.
    A continuación, se inicia una transacción de fragmento  */
        val bundle = Bundle()
        bundle.putInt("id", id)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

/*utilizando supportFragmentManager.beginTransaction() y se reemplaza el contenedor de fragmentos en la vista principal con el
fragmento DetailFragment. Se agrega la transacción al back stack para que se pueda volver atrás mediante el botón de retroceso.
Finalmente, se confirma la transacción con commit().*/
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null) // agregar al stack para volver con back
            .commit()
    }


}