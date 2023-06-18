package com.example.inicio.data.domain

interface SelectedListener {/*La interfaz SelectedListener se utiliza para comunicar eventos de selección de elementos
dentro del contexto de la aplicación. Al implementar esta interfaz en una clase, puedes establecer un listener que se
active cuando se selecciona un elemento específico.*/

    fun onSelected(id: Int)
    /*El método onSelected(id: Int) es el punto central de la interfaz. Recibe un parámetro id que representa la identificación
    del elemento seleccionado. Puedes utilizar este método para realizar acciones específicas basadas en la selección de un
    elemento, como mostrar detalles, iniciar una acción o cualquier otra lógica relacionada.*/
}