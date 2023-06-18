@file:Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")

package com.example.inicio.ui.view

import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.databinding.FragmentListBinding

import com.example.inicio.data.domain.SelectedListener
import com.example.inicio.ui.view.adapters.ItemAdapter
import com.example.inicio.ui.viewmodel.ApiStatus
import com.example.inicio.ui.viewmodel.PokeViewModel

import java.lang.ClassCastException


class ListFragment : Fragment() {
/*a clase ListFragment, que es un fragmento utilizado para mostrar una lista de Pokémon en la interfaz de usuario.*/

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: PokeViewModel by viewModels()
    /*Utiliza el PokeViewModel para obtener la lista de Pokémon y el estado de la API. */


    private lateinit var adapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView


    private lateinit var listener: SelectedListener

    override fun onAttach(context: Context) {
        /*esta función se utiliza para establecer la comunicación entre un fragmento y la actividad que lo contiene,
        asegurándose de que la actividad implemente la interfaz SelectedListener.
        Esto permite al fragmento enviar información o eventos a la actividad a través del listener.*/

        super.onAttach(context)
        listener = try {
            context as SelectedListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context debe implementar el listener")
        }
    }

    override fun onCreateView(
        /* esta función infla y configura la vista del fragmento utilizando el archivo de enlace FragmentListBinding,
        y se asegura de manejar correctamente el caso de un valor nulo para evitar errores al subir el código a GitHub.*/

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        /*Codigo implementado para arreglar del valor nulo para poder subirlo a github */
        val binding = _binding ?: return null
        /*----------------------------------------------------*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*configura un ItemAdapter y un RecyclerView para mostrar los elementos de la lista de Pokémon.*/
        super.onViewCreated(view, savedInstanceState)
        // val viewModel2 = ViewModelProvider(this)[PokeViewModel::class.java]
        adapter = ItemAdapter()
        recyclerView = binding.recyclerViewPoke
        recyclerView.adapter = adapter

        observeApiStatus()
        observeListPokemon()
        onClickItem()
    }

    private fun observeApiStatus() {

        /*La función observeApiStatus se utiliza para observar el estado de la API y ajustar la visibilidad de los elementos de
        la interfaz de usuario en función de ese estado, como la carga en curso, la carga completada o un error.*/
        viewModel.status.observe(viewLifecycleOwner) { status->
            when (status) {
                ApiStatus.LOADING -> {
                    binding.statusOffline.visibility = View.GONE
                    binding.shimmerLoading.visibility = View.VISIBLE
                    binding.recyclerViewPoke.visibility =View.GONE
                }
                ApiStatus.ERROR -> {
                    binding.statusOffline.visibility = View.VISIBLE
                    binding.shimmerLoading.visibility = View.GONE
                    binding.recyclerViewPoke.visibility =View.GONE
                }
                ApiStatus.DONE -> {
                    binding.statusOffline.visibility = View.GONE
                    binding.shimmerLoading.visibility = View.GONE
                    binding.recyclerViewPoke.visibility =View.VISIBLE
                }
            }
        }
    }

    private fun observeListPokemon() {
        /*La función observeListPokemon se utiliza para observar los cambios en la lista de Pokémon y
        enviar la lista actualizada al adaptador ItemAdapter.*/

        viewModel.pokemonList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onClickItem() {
        /*La función onClickItem se utiliza para manejar el evento de clic en un elemento de la lista de Pokémon.
        Cuando se hace clic en un elemento, se invoca el método onSelected del SelectedListener para notificar al
        contexto padre (que debe implementar el SelectedListener) que se ha seleccionado un Pokémon.*/

        adapter.onItemClickListener = { poke ->
            //Toast.makeText(requireContext(), poke.name, Toast.LENGTH_LONG).show()
            //test(poke.id)
            listener.onSelected(poke.id)
        }
    }



    override fun onDestroyView() {
        /*se utiliza para liberar los recursos relacionados con la vista del fragmento y evitar posibles fugas de memoria
        al destruir la vista del fragmento.*/
        super.onDestroyView()
        _binding = null
    }

}