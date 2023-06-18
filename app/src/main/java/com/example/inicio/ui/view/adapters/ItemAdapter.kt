package com.example.inicio.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.R
import com.example.inicio.databinding.ListItemBinding
import com.example.inicio.data.domain.model.PokeItem
import com.squareup.picasso.Picasso


class ItemAdapter : ListAdapter<PokeItem, ItemAdapter.ViewHolder>(DiffCallBack) {
    /*Este código de Android Studio define la clase ItemAdapter, que es un adaptador personalizado para un RecyclerView.
    Su propósito es manejar la visualización de una lista de elementos PokeItem en una interfaz de usuario.*/

    // para hacer click
    lateinit var onItemClickListener: (PokeItem) -> Unit   /* propiedad onItemClickListener que es una función de retroceso.
    Al establecer esta propiedad, puedes especificar una función que se llamará cuando se haga clic en un elemento de la lista.
     Dentro de la función bind del ViewHolder, se configura un OnClickListener en la vista raíz del elemento de la lista,
     y cuando se hace clic, se llama a la función onItemClickListener con el PokeItem correspondiente.*/

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ListItemBinding.bind(view)

        fun bind(pokeItem: PokeItem) {
            binding.tvId.text = pokeItem.formatId
            binding.tvName.text = pokeItem.name
            Picasso.get().load(pokeItem.img)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(binding.ivPokemon)

            view.setOnClickListener {
                onItemClickListener(pokeItem)
            }
        }
/*La clase ItemAdapter tiene una clase interna llamada ViewHolder, que se utiliza para mantener las referencias de los
elementos de la vista del elemento de la lista. En el método bind, se asignan los valores del PokeItem a los elementos
de la vista correspondientes, como el número de identificación, el nombre y la imagen del Pokémon.*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {/*Método necesarios para crear y enlazar vistas para cada elemento de la lista.*/
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {/*Método necesarios para crear y enlazar vistas para cada elemento de la lista.*/
        val item = getItem(position)
        return holder.bind(item)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PokeItem>() {
/*interfaz DiffUtil.ItemCallback para realizar comparaciones eficientes entre los elementos de la lista y determinar si han
cambiado o son los mismos. Esto se utiliza para realizar actualizaciones precisas en el RecyclerView solo cuando sea necesario.*/
        override fun areItemsTheSame(oldItem: PokeItem, newItem: PokeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PokeItem, newItem: PokeItem): Boolean {
            return oldItem == newItem
        }

    }

}